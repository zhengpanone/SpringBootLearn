package com.zp.service;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * Author : zhengpanone
 * Date : 2024/1/26 17:10
 * Version : v1.0.0
 * Description: TODO
 */
@DubboService
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
