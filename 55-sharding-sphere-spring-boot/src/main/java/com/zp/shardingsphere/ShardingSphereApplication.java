package com.zp.shardingsphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Author : zhengpanone
 * Date : 2025/2/25 09:49
 * Version : v1.0.0
 * Description:
 */
@EnableAsync
@EnableTransactionManagement
@SpringBootApplication
public class ShardingSphereApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereApplication.class, args);
    }
}

