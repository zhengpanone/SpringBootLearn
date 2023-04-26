package com.zp.controller;

import ch.qos.logback.core.util.TimeUtil;
import com.zp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/")
    public String demo() throws InterruptedException {
        // Thread.sleep(10000);
        TimeUnit.SECONDS.sleep(10);

        testService.test();
        return "demo";
    }
}
