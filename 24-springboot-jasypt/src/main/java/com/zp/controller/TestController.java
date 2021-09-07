package com.zp.controller;

import com.zp.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author zhengpanone
 * @since 2021-09-18
 */
@RestController
@Slf4j
public class TestController {
    @GetMapping("/test")
    public Person test() {
        Person person = Person.builder()
                .realName("张三")
                .address("湖北武汉")
                .phoneNumber("12345678901")
                .idCard("123456789012").build();
        log.debug(person.toString());
        return person;
    }
}
