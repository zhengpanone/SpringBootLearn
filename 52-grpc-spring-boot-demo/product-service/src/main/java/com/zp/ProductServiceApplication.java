package com.zp;


import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Map;

/**
 * Author : zhengpanone
 * Date : 2024/8/8 12:28
 * Version : v1.0.0
 * Description: TODO
 */
@SpringBootApplication
public class ProductServiceApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}
