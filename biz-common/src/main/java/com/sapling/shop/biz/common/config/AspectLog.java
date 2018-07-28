package com.sapling.shop.biz.common.config;

import com.sapling.shop.biz.common.web.BaseResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun
 * @create 2017/11/8
 */
//@Component
//@Aspect
public class AspectLog {
    private static final Logger LOGGER = LoggerFactory.getLogger(AspectLog.class);

    /**
     * +
     * 前置通知
     *
     * @param joinPoint
     */
    @Before("execute()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Map<String, String> parameters = new HashMap<>();
        Method method = signature.getMethod();
        MDC.put("method", method.getName());

        Parameter[] parametersReflect = method.getParameters();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < parametersReflect.length; i++) {
            parameters.put(parametersReflect[i].getName(), args[i] != null ? args[i].toString() : null);
        }
        LOGGER.info("开始请求接口{}", method.getName());
    }

    @Pointcut("execution(* com.sapling.shop.*.*Controller.*(..))")
    public void execute() {
    }

    /**
     * 环绕通知
     *
     * @param proceedingJoinPoint
     *
     * @throws Throwable
     */
    @Around("execute()")
    public BaseResponse around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long beforeTimeStamp = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        BaseResponse response = null;
        if (object!=null) {
            response = (BaseResponse) proceedingJoinPoint.proceed();
        }
        long afterTimeStamp = System.currentTimeMillis();

        LOGGER.info("本次请求共消耗时间为{}ms", afterTimeStamp - beforeTimeStamp);

        return response;
    }

    /**
     * 后置通知
     *
     * @param joinPoint
     */
    @After("execute()")
    public void after(JoinPoint joinPoint) {
        
    }
}
