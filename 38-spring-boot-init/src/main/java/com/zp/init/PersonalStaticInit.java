package com.zp.init;

import org.springframework.stereotype.Component;

@Component
public class PersonalStaticInit {
    static {
        System.out.println("spring容器初始化方式：静态代码块实现初始化");
    }
}
