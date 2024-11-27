package com.zp.service;

import com.zp.proto.Product;
import com.zp.proto.ProductServiceGrpc;
import com.zp.vo.ProductVO;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author : zhengpanone
 * Date : 2024/8/8 13:50
 * Version : v1.0.0
 * Description: TODO
 */
@Service
public class ProductServiceRPC {
    @GrpcClient("grpc-product-service")
    ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub;

    public ProductVO getProduct(int id) {
        Product product = Product.newBuilder().setProductId(1).build();
        Product response = productServiceBlockingStub.getProductById(product);
        ProductVO productVO = ProductVO.builder().id(response.getProductId()).name(response.getName()).price(response.getPrice()).build();
        return productVO;
    }
}
