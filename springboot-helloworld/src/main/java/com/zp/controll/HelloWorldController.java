package com.zp.controll;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController和RequestMapping注解来自SpringMVC的注解
 * RestController：提供实现了REST API，可以服务JSON,XML或者其他。这里是以String的形式渲染出结果。
 * RequestMapping：提供路由信息，"/“路径的HTTP Request都会被映射到sayHello方法进行处理。
 */

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String sayHello() {
        return "Hello World!";

    }
}
