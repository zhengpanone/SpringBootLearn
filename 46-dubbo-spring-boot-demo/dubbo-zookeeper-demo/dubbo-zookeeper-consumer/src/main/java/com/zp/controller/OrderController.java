package com.zp.controller;

import com.zp.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author : zhengpanone
 * Date : 2023/11/29 10:29
 * Version : v1.0.0
 * Description: 订单Controller
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order")
    public String getOrder() {
        return orderService.getOrder();
    }
    @GetMapping("/clientStream")
    public String clientStream() {
        return orderService.clientStream();
    }
}
