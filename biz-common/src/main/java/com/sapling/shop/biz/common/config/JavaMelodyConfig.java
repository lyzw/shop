package com.sapling.shop.biz.common.config;


import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.MonitoringSpringAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:net/bull/javamelody/monitoring-spring-aspectj.xml"})
public class JavaMelodyConfig {
    @Bean
    public FilterRegistrationBean getJavaMelodyFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new MonitoringFilter());
        registration.setAsyncSupported(true);
        return registration;
    }

    @Bean
    public MonitoringSpringAdvisor getMonitoringSpringAdvisor(@Value("${timetalk.javaMedoly.classPattern:com" +
            ".shanlinjinrong.timetalk.*.*}") String[] classPatterns) {
        MonitoringSpringAdvisor monitoringSpringAdvisor = new MonitoringSpringAdvisor();
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPatterns(classPatterns);
        monitoringSpringAdvisor.setPointcut(pointcut);
        return monitoringSpringAdvisor;
    }

//    @Bean
//    public Logger.Level feignLoggerLevel() {
//        return Logger.Level.FULL;
//    }

}
