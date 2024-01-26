package com.zp;

import com.zp.service.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author : zhengpanone
 * Date : 2024/1/26 17:40
 * Version : v1.0.0
 * Description: TODO
 */
@SpringBootApplication
@EnableDubbo
public class ConsumerApplication implements CommandLineRunner {
    @DubboReference
    private DemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.demoService.sayHello("张三"));
    }
}
