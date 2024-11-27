package com.zp.controller;

import com.zp.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author : zhengpanone
 * Date : 2023/11/29 10:25
 * Version : v1.0.0
 * Description: TODO
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/user")
    public String getUser() {
        return userService.getUser();
    }
}
