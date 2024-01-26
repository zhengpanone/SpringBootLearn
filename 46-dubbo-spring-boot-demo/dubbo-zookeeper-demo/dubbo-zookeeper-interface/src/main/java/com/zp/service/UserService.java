package com.zp.service;

import org.apache.dubbo.common.stream.StreamObserver;

/**
 * Author : zhengpanone
 * Date : 2023/11/29 10:25
 * Version : v1.0.0
 * Description: TODO
 */

public interface UserService {
    // UNARY
    String getUser();

    // SERVER_STREAM
    default void sayHelloServerStream(String name, StreamObserver<String> response) throws InterruptedException {

    }

    // CLIENT_STREAM / BI_STREAM
    default StreamObserver<String> syaHelloStream(StreamObserver<String> response) {
        return response;
    }

} 
