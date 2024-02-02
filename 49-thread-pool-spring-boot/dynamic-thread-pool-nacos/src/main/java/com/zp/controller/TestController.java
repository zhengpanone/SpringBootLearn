package com.zp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : zhengpanone
 * Date : 2024/2/2 12:51
 * Version : v1.0.0
 * Description: TODO
 */
@RestController
public class TestController {


    @GetMapping("/")
    public void test() {

    }

    @GetMapping("/test2")
    public void test2() {


    }
}
