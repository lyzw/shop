package com.sapling.shop.biz.common.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据源配置类
 *
 * @author zhouwei
 * @since 2017/5/4
 */
@Configuration
@ConfigurationProperties
public class DruidDataSourceConfig {
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSourceOne(){
        return DruidDataSourceBuilder.create().build();
    }
}
