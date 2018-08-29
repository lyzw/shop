package com.sapling.shop.biz.common.aspectj;

import com.sapling.shop.biz.common.web.BaseResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 慢请求日志拦截器
 * @author weizhou
 * @version v1.0
 * @date 2018/7/15
 * @since v1.0
 */
@Aspect
@Component
@ConfigurationProperties
@Configuration
public class SlowRequestAspectLog {

    @Value("${logger.request.slow.enable:true}")
    Boolean enable;
    @Value("${logger.request.slow.capacity:1}")
    Long capacity;

    @Pointcut("execution(* com.sapling.shop.*.*Controller.*(..))")
    public void pointCut(){};


    /**
     * 环绕通知
     *
     * @param proceedingJoinPoint
     *
     * @throws Throwable
     */
    @Around("pointCut()")
    public BaseResponse around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long beforeTimeStamp = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        BaseResponse response = null;
        if (object!=null) {
            response = (BaseResponse) proceedingJoinPoint.proceed();
        }
        long cost = System.currentTimeMillis() - beforeTimeStamp;

        if (enable && cost > capacity) {
            System.out.println(
                    "本次请求共消耗时间为(ms):" + cost);
        }

        return response;
    }
}
