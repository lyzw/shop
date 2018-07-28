package com.sapling.shop;

import com.sapling.shop.biz.common.filter.AuthTokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class,args);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        AuthTokenFilter tokenAuthorFilter = new AuthTokenFilter();
        registrationBean.setFilter(tokenAuthorFilter);
        return registrationBean;
    }
}
