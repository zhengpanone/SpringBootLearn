package com.zp.beans;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        // BeanDefinition 存储Bean的描述信息,决定bean生成方式
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(DepartmentService.class);
        rootBeanDefinition.getPropertyValues().add("name","张三");
        //这里注册bean
        registry.registerBeanDefinition("departmentService",rootBeanDefinition);
    }
}
