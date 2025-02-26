package com.zp.webflux.r2dbc.controller;

import com.zp.webflux.r2dbc.entity.Users;
import com.zp.webflux.r2dbc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : zhengpanone
 * Date : 2025/2/26 10:42
 * Version : v1.0.0
 * Description:
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/insert")
    public Mono<Users> insertByTemplate(@RequestBody Users users) {
        return userService.insertByTemplate(users);
    }

    @GetMapping("/remove/{id}")
    public Mono<Integer> removeByTemplate(@PathVariable("id") Long id) {
        return userService.removeByTemplate(id);
    }

    @PostMapping("/update")
    public Mono<Integer> updateByTemplate(@RequestBody Users users) {
        return userService.updateByTemplate(users);
    }

    @GetMapping("/query/{id}")
    public Mono<Users> selectByTemplate(@PathVariable("id") Long id) {
        return userService.selectByTemplate(id).single();
    }

    @GetMapping("/pager")
    public Mono<ResponseEntity<List<Users>>> selectByTemplate(Integer page, Integer size) {
        return userService.selectByTemplatePager(page, size);
    }

    @GetMapping("/count")
    public Mono<Long> selectCountByTemplateCount() {
        return userService.selectCountByTemplateCount();
    }
}
