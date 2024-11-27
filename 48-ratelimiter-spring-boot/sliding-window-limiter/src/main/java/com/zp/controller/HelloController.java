package com.zp.controller;

import com.zp.annotation.RateLimiter;
import com.zp.enums.LimitType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : zhengpanone
 * Date : 2024/2/1 14:23
 * Version : v1.0.0
 * Description: TODO
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    @RateLimiter(time = 10, count = 3, limitType = LimitType.DEFAULT) // 10秒内允许访问三次
    public String hello() {
        return "Hello";
    }
}
