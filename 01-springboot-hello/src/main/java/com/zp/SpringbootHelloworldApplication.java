package com.zp;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // SpringBoot引导类
public class SpringbootHelloworldApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringbootHelloworldApplication.class, args);
        SpringApplication springApplication = new SpringApplication(SpringbootHelloworldApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);//关闭logo
        springApplication.run(args);
    }

}

