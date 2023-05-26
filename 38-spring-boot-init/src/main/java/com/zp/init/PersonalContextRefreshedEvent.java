package com.zp.init;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class PersonalContextRefreshedEvent implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("spring容器初始化方式：实现ApplicationListener<ContextRefreshedEvent>接口");
    }
}
