package com.sapling.shop.biz.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;


/**
 * Mybatis配置信息
 *
 * @author lijinlei
 * @since 2017/6/10
 */
@Configuration
@MapperScan(basePackages = {"com.sapling.shop.biz.common.mybatis.mapper"})
public class MyBatisConfig implements TransactionManagementConfigurer {

    private static final Logger LOG = LoggerFactory.getLogger(MyBatisConfig.class);

    @Autowired
    DataSource dataSource;

    /**
     * @return sqlSessionFactory
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            LOG.error("{}",e);;
            throw new RuntimeException(e);
        }
    }

    @Override
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
