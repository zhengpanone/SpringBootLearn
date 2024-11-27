package com.zp.service;

import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * Author : zhengpanone
 * Date : 2023/11/29 10:29
 * Version : v1.0.0
 * Description: TODO
 */
@Service
public class OrderService {
    @DubboReference
    private UserService userService;

    public String getOrder() {
        // unary
        // String user = userService.getUser();
        // return "consumer service result" + user + ":order";
        try {
            userService.sayHelloServerStream("hello", new StreamObserver<String>() {
                @Override
                public void onNext(String data) {
                    System.out.println("接收到结果:" + data);
                }

                @Override
                public void onError(Throwable throwable) {

                }

                @Override
                public void onCompleted() {
                    System.out.println("结束");
                }
            });
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "success";
    }

    // BI_STREAM
    public String clientStream() {

        StreamObserver<String> result = userService.syaHelloStream(new StreamObserver<String>() {
            @Override
            public void onNext(String data) {
                System.out.println("接收到结果:" + data);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                System.out.println("结束");
            }
        });
        result.onNext("response1");
        result.onCompleted();
        return "client stream successfully";

    }
}
