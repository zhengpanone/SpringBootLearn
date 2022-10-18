package com.zp.service;

/**
 * HelloService
 * 服务类
 * @author zhengpanone
 * @since 2022-10-18
 */
public class HelloService {
    private String name;
    private String address;
    public HelloService(String name,String address){
        this.name=name;
        this.address=address;
    }
    public String sayHello(){
        return "你好，我的名字叫"+name+"，我来自"+address;
    }
}
