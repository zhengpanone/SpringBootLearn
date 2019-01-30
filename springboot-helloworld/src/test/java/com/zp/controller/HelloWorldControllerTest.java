package com.zp.controller;

import com.zp.controll.HelloWorldController;
import org.junit.Test;

import static org.junit.Assert.*;   //必须是static

public class HelloWorldControllerTest {
    HelloWorldController app = new HelloWorldController();

    @Test
    public void testBaseClass() {
        assertTrue(app.sayHello().equals("Hello World!"));
    }


    @Test
    public void testSayHello() {
        /**
         * assertEquals(Object expected, Object actual)
         * expected 是期望值
         * actual 是被测代码返回的实际值
         */
        assertEquals("Hello World!", new HelloWorldController().sayHello());


    }
}
