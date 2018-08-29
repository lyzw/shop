package com.sapling.shop.biz.common.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/8/7
 * @since v1.0
 */
@Aspect
@Component
@ConfigurationProperties
@Configuration
public class MethodMeasureAspect {

    private static final Logger logger = LoggerFactory.getLogger(MethodMeasureAspect.class);

    @Pointcut("@annotation(com.sapling.shop.biz.common.annotation.MethodMeasureAnnotation)")
    public void execute() {
    }

    @Around("execute()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = className + "_" + getMethodName(joinPoint);
        long startTime = System.currentTimeMillis();
        try {
            obj = joinPoint.proceed();
        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
            throw t;
        } finally {
            long costTime = System.currentTimeMillis() - startTime;
            logger.info("method={}, cost_time={}", methodName, costTime);
        }
        return obj;
    }


    public String getMethodName(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        return method.getName();
    }


}
