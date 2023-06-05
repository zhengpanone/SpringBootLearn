package com.zp.beans;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

public class UserService {
    @PostConstruct
    public void init() {
        System.out.println("userService init");
    }
}
