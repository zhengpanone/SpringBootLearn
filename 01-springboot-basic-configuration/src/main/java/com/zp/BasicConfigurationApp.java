package com.zp;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot基础配置
 */
@SpringBootApplication // SpringBoot引导类
public class BasicConfigurationApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BasicConfigurationApp.class);
        app.setBannerMode(Banner.Mode.LOG);//关闭logo
        app.run(args);
    }

}

