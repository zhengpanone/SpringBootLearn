package com.zp.controller;

import com.zp.log.MyLog;
import com.zp.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author zhengpanone
 * @since 2022-10-18
 */
@RestController
@RequestMapping("/")
public class HelloController {
    @Autowired
    private HelloService helloService; //当前实例已经由自定义的starter完成了创建
    @RequestMapping("/test")
    @MyLog(desc = "sayhell方法")
    public String hello(){
        return helloService.sayHello();
    }
}
