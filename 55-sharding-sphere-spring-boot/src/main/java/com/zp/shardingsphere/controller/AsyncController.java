package com.zp.shardingsphere.controller;

import cn.hutool.core.collection.ListUtil;
import com.zp.shardingsphere.domain.Order;
import com.zp.shardingsphere.service.IAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Author : zhengpanone
 * Date : 2025/2/25 09:47
 * Version : v1.0.0
 * Description:
 */
@Slf4j
@RestController
public class AsyncController {
    @Resource
    private IAsyncService asyncService;

    @GetMapping("/test")
    public String testAsyncInsert() {
        CountDownLatch c;
        try {
            List<Order> data = getData();
            List<List<Order>> partition = ListUtil.partition(data, 2000);
            c = new CountDownLatch(partition.size());
            for (List<Order> list : partition) {
                asyncService.add(list, c);
            }
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("所有的数据插入完毕");
        }
        return "执行完毕";
    }


    private List<Order> getData() {
        List<Order> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Order order = new Order();
            order.setOrderName("苹果" + i);
            order.setUserId(i + 1);
            list.add(order);
        }
        return list;
    }
}
