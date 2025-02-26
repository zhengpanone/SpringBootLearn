package com.zp.shardingsphere.service.impl;

import com.zp.shardingsphere.domain.Order;
import com.zp.shardingsphere.service.IAsyncService;
import com.zp.shardingsphere.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Author : zhengpanone
 * Date : 2025/2/25 09:48
 * Version : v1.0.0
 * Description:
 */
@Slf4j
@Service
public class AsyncServiceImpl implements IAsyncService {
    @Resource
    private IOrderService orderService;

    @Async("asyncServiceExecutor")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(List<Order> orderList, CountDownLatch countDownLatch) {
        try {
            log.debug(Thread.currentThread().getName() + "开始插入数据");
            orderService.saveBatch(orderList);
            log.debug(Thread.currentThread().getName() + "插入数据完成");
        } finally {
            countDownLatch.countDown();
        }
    }
}
