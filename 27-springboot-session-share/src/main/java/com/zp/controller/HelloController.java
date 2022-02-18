package com.zp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * HelloController
 *
 * @author zhengpanone
 * @since 2021-12-07
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    Integer port;

    @GetMapping("/set")
    public String set(HttpSession session) {
        session.setAttribute("user", "zhengpanone");
        return String.valueOf(port);
    }

    @GetMapping("/get")
    public String get(HttpSession session) {
        return session.getAttribute("user") + ":" + port;
    }
}
