package com.zp.config;

import com.zp.proto.ProductServiceGrpc;
import com.zp.proto.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author : zhengpanone
 * Date : 2024/8/8 14:18
 * Version : v1.0.0
 * Description: 定义接口的Stub实例，用于发起远程服务调用
 */
@Configuration
public class GrpcServiceConfig {
    @Bean
    public ManagedChannel getChannel() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext().build();
        return channel;
    }

   /* @Bean
    public ProductServiceGrpc.ProductServiceBlockingStub getBlockingStub(ManagedChannel channel) {
        return ProductServiceGrpc.newBlockingStub(channel);
    }*/

    @Bean
    public UserServiceGrpc.UserServiceBlockingStub getBlockingStub2(ManagedChannel channel) {
        return UserServiceGrpc.newBlockingStub(channel);
    }


}
