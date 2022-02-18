package com.zp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * RestController和RequestMapping注解来自SpringMVC的注解
 * RestController：提供实现了REST API，可以服务JSON,XML或者其他。这里是以String的形式渲染出结果。
 * RequestMapping：提供路由信息，"/“路径的HTTP Request都会被映射到sayHello方法进行处理。
 */

@RestController
public class HelloWorldController {
    @Autowired
    DataSource dataSource;
    @RequestMapping("/")
    public Map<String, Object> sayHello() {
        System.out.println("dataSource"+ dataSource);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "HelloWorld！");
        return map;

    }

}
