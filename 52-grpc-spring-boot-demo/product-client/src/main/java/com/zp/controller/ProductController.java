package com.zp.controller;

import com.zp.service.ProductServiceRPC;
import com.zp.vo.ProductVO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : zhengpanone
 * Date : 2024/8/8 13:53
 * Version : v1.0.0
 * Description: TODO
 */
@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductServiceRPC productServiceRPC;

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductVO> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(productServiceRPC.getProduct(id));
    }
}
