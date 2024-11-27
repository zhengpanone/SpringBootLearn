package com.zp.service;


import com.zp.proto.Category;
import com.zp.proto.Product;
import com.zp.proto.ProductList;
import com.zp.proto.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.rmi.registry.Registry;

/**
 * Author : zhengpanone
 * Date : 2024/8/8 11:14
 * Version : v1.0.0
 * Description: TODO
 */
@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {
    /**
     * <pre>
     * unary - synchronous
     * request-response stype [not streaming]
     * </pre>
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void getProductById(Product request, StreamObserver<Product> responseObserver) {
        System.out.println("ProductService 接收到的参数, request" + request);
        Product response = Product.newBuilder().setProductId(1).setCategoryId(1).setPrice(100).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getProductByCategoryId(Category request, StreamObserver<ProductList> responseObserver) {
        super.getProductByCategoryId(request, responseObserver);
    }
}
