package com.zp.controller;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;   //必须是static

public class HelloWorldControllerTest {
    HelloWorldController app = new HelloWorldController();

    /**
     * assertEquals(Object expected, Object actual)
     * expected 是期望值
     * actual 是被测代码返回的实际值
     */
    @Test
    public void testSayHello() {
        Map<String, String> map = new HashMap<>();
        map.put("msg", "HelloWorld!");
        assertEquals(map, new HelloWorldController().sayHello());
    }

}
