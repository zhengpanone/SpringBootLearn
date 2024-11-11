package com.zp.activemq.controller;

import com.zp.activemq.handler.JmsProducer;
import com.zp.activemq.model.DefaultMqModel;
import com.zp.activemq.model.SecondMqModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author : zhengpanone
 * Date : 2024/10/25 12:26
 * Version : v1.0.0
 */
@RestController
@RequestMapping("/activemq")
public class ActiveMQController {
    @Autowired
    JmsProducer jmsProducer;

    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public DefaultMqModel test() {
        DefaultMqModel defaultMqModel = new DefaultMqModel();
        defaultMqModel.setContent("hahahahahahhahaha哈啊哈哈");
        defaultMqModel.setTitle("测试");
        defaultMqModel.setType(1);
        jmsProducer.send(defaultMqModel);
        return defaultMqModel;
    }

    @RequestMapping(value = "/test2", method = {RequestMethod.GET})
    public SecondMqModel test2() {
        SecondMqModel secondMqModel = new SecondMqModel();
        secondMqModel.setContent("asdasdasd哈啊哈哈");
        secondMqModel.setTitle("测试2");
        secondMqModel.setRemark("第二个");
        secondMqModel.setType(2);
        jmsProducer.send(secondMqModel);
        return secondMqModel;
    }
}
