package com.zp.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1、通过 @Bean
 * 2、通过 @Import 无法干预实例化
 * 3、通过实现ImportBeanDefinitionRegistrar接口，重写registerBeanDefinitions方法
 * 4、通过实现BeanDefinitionRegistryPostProcessor接口，重写postProcessBeanDefinitionRegistry方法
 */
@Configuration
@Import({RoleService.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig {
    @Bean
    public UserService userService() {
        return new UserService();
    }

}
