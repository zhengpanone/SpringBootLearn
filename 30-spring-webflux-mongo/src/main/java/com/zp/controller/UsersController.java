package com.zp.controller;

import com.mongodb.client.result.UpdateResult;
import com.zp.pojo.Users;
import com.zp.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * UsersController
 *
 * @author zhengpanone
 * @since 2022-01-18
 */
@RestController
public class UsersController {
    @Resource
    private UserService userService;

    @PostMapping("/save")
    public Mono<Users> save(@RequestBody Users users) {
        return userService.save(users);
    }

    @PutMapping("/update")
    public Mono<UpdateResult> update(@RequestBody Users users) {
        return userService.updateInfo(users);
    }

    @DeleteMapping("/delete")
    public Mono<Void> removeById(Long id) {
        return userService.removeById(id);
    }

    @GetMapping("/find")
    public Flux<Users> queryByUserName( String keyword) {
        return userService.findUserLike(keyword);
    }

    @GetMapping("/findAll")
    public Flux<Users> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findPage")
    public Flux<Users> findPage(Integer page, Integer size) {
        return userService.queryPage(page, size);
    }

}
