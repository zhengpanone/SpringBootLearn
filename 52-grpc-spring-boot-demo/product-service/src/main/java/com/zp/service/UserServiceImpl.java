package com.zp.service;

import com.zp.proto.UserRequest;
import com.zp.proto.UserResponse;
import com.zp.proto.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * Author : zhengpanone
 * Date : 2024/8/8 14:48
 * Version : v1.0.0
 * Description: TODO
 */
@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void query(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        System.out.println("UserService 接收到的参数, name:" + request.getName());
        UserResponse response = UserResponse.newBuilder().setName("测试").setAge(34).setAddress("湖北").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
