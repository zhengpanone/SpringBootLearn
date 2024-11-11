package com.zp.activemq.handler;

import com.zp.activemq.model.DefaultMqModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Author : zhengpanone
 * Date : 2024/10/25 12:18
 * Version : v1.0.0
 */
@Component
public class JmsProducer {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${jms.destQueueName}")
    String destQueueName;

    public void send(DefaultMqModel defaultMqModel) {
        jmsTemplate.convertAndSend(destQueueName, defaultMqModel);
    }
}
