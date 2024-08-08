package com.zp.controller;

import com.zp.proto.UserRequest;
import com.zp.proto.UserResponse;
import com.zp.proto.UserServiceGrpc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author : zhengpanone
 * Date : 2024/8/8 15:00
 * Version : v1.0.0
 * Description: TODO
 */
@RestController
public class UserController {

    @Resource
    UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    @GetMapping("/query")
    public String query() {
        UserRequest request = UserRequest.newBuilder().setName("测试").build();
        UserResponse userResponse = userServiceBlockingStub.query(request);
        String result = String.format("name:%s,age:%d,address:%s", request.getName(), userResponse.getAge(), userResponse.getAddress());
        return result;
    }
}
