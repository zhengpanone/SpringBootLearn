package com.zp.netty.controller;

import com.zp.netty.service.PUshMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : zhengpanone
 * Date : 2024/3/8 15:17
 * Version : v1.0.0
 * Description: TODO
 */
@RestController
@RequestMapping("/push")
public class TestController {
    @Autowired
    PUshMsgService pushMsgService;

    @GetMapping("/{uid}")
    public void pushOne(@PathVariable String uid) {
        pushMsgService.pushMsgToOne(uid, "hello---------------");
    }

    @GetMapping("/pushAll")
    public void pushMsgToAll() {
        pushMsgService.pushMsgToAll("hello all ----------------");
    }
}
