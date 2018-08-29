package com.sapling.shop;

import com.sapling.shop.biz.common.filter.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterConfig;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/15
 * @since v1.0
 */
@SpringBootConfiguration
@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration

public class ApplicationStarter {


    @Value("${auth.exclude.urls:11}")
    String excludeUrls;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class,args);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(@Autowired AuthTokenFilter tokenAuthorFilter) {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(tokenAuthorFilter);
        return registrationBean;
    }


}
