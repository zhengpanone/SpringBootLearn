package com.zp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * UserServiceTest
 *
 * @author zhengpanone
 * @since 2022-02-18
 */

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void findAll() {
        System.out.println(userService.findAll());
    }

    @Test
    public void findOne() {
        System.out.println(userService.findOne(1L));
    }
}
