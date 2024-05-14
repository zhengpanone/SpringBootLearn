package com.zp.service;

import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;


/**
 * Author : zhengpanone
 * Date : 2023/11/29 10:25
 * Version : v1.0.0
 * Description: TODO
 */
@DubboService
public class UserServiceImpl implements UserService {
    @Override
    public String getUser() {
        return "zhengpanone";
    }

    // Server_Stream
    @Override
    public void sayHelloServerStream(String name, StreamObserver<String> response) throws InterruptedException {
        // 处理返回响应1
        Thread.sleep(2 * 1000);
        response.onNext("hello" + name);
        // 处理返回响应2
        Thread.sleep(3 * 1000);
        response.onNext("response2" + name);
        // 处理返回响应3
        Thread.sleep(4 * 1000);
        response.onNext("response2" + name);
        response.onCompleted();
    }

    @Override
    public StreamObserver<String> syaHelloStream(StreamObserver<String> response) {
        return new StreamObserver<String>() {
            @Override
            public void onNext(String data) {
                System.out.println("服务端接收到的data:" + data);
                // 处理
                response.onNext("响应结果" + data);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                System.out.println("发送完成");
            }
        };
    }
}
