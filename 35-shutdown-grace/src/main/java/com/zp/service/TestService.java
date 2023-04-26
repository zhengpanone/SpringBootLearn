package com.zp.service;

import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class TestService {
    @PreDestroy
    private void destroy(){
        System.out.println("testService destroy...");
    }
    public void test(){
        System.out.println("service method");
    }
}
