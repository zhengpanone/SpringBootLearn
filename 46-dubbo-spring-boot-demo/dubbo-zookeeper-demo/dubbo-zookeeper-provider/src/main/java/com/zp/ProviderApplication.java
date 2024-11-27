package com.zp;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.management.ManagementFactory;

/**
 * Author : zhengpanone
 * Date : 2023/11/29 10:22
 * Version : v1.0.0
 * Description: TODO
 */
@SpringBootApplication
@EnableDubbo
public class ProviderApplication {
    public static void main(String[] args) {
        System.out.println("JVM Arguments: "+ ManagementFactory.getRuntimeMXBean().getInputArguments());
        SpringApplication.run(ProviderApplication.class, args);
    }
}
