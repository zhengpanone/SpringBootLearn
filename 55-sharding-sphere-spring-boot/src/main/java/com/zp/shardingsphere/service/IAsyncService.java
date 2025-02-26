package com.zp.shardingsphere.service;

import com.zp.shardingsphere.domain.Order;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Author : zhengpanone
 * Date : 2025/2/25 09:48
 * Version : v1.0.0
 * Description:
 */
public interface IAsyncService {
    void add(List<Order> orderList, CountDownLatch countDownLatch);
}
