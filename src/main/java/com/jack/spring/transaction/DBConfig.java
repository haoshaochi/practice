package com.jack.spring.transaction;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @author 马钊
 * @date 2020-07-29 18:26
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan("com.jack.spring.transaction")
@EnableConfigurationProperties
public class DBConfig {
    @Autowired
    private DataSourceBean dataSourceBean;
    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dataSourceBean.getUrl());
        druidDataSource.setUsername(dataSourceBean.getName());
        druidDataSource.setPassword(dataSourceBean.getPwd());
        druidDataSource.setDriverClassName(dataSourceBean.getDclass());
        return druidDataSource;
    }
}
