package com.zp.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


/**
 * Author : zhengpanone
 * Date : 2024/2/2 14:23
 * Version : v1.0.0
 * Description: TODO
 */
@Component
public class AsyncMethod {
    /**
     * 异步方法，如果@Async加在类的上面，则整个类中的方法都是异步的
     */
    @Async
    public void print() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
