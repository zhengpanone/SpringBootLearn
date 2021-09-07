package com.zp.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * JdbcConfig
 *
 * @author zhengpanone
 * @since 2021-09-07
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.driverclassname}")
    String dirverClassName;
    @Value("${jdbc.username}")
    String userName;
    @Value("${jdbc.password}")
    String password;

@Bean
    public DataSource dataSource(){
    DruidDataSource druidDataSource = new DruidDataSource();
    druidDataSource.setDriverClassName(dirverClassName);
    druidDataSource.setUrl(url);
    druidDataSource.setUsername(userName);
    druidDataSource.setPassword(password);
    return druidDataSource;
    }

}
