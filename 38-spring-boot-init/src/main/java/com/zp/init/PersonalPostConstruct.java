package com.zp.init;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PersonalPostConstruct {
    @PostConstruct
    public void initialize(){
        System.out.println("spring容器初始化方式：PostConstruct注解实现初始化");
    }
}
