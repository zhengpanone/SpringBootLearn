package com.zp.config;

import com.zp.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HelloServiceAutoConfiguration
 * 自动配置类用来配置HelloService对象,基于Java bean配置
 *
 * @author zhengpanone
 * @since 2022-10-18
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {
    private HelloProperties helloProperties;

    // 通过构造方法注入配置属性对象HelloProperties
    public HelloServiceAutoConfiguration(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    // 实例化HelloService并载入Spring IOC容器
    @Bean
    @ConditionalOnMissingBean // 没有HelloService则创建
    public HelloService helloService() {
        return new HelloService(helloProperties.getName(), helloProperties.getAddress());
    }
}
