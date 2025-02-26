package com.zp.shardingsphere.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zp.shardingsphere.domain.Order;
import com.zp.shardingsphere.mapper.OrderMapper;
import com.zp.shardingsphere.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * Author : zhengpanone
 * Date : 2025/2/25 09:49
 * Version : v1.0.0
 * Description:
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
}
