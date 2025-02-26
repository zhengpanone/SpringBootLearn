package com.zp.shardingsphere.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zp.shardingsphere.domain.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author : zhengpanone
 * Date : 2025/2/25 09:48
 * Version : v1.0.0
 * Description:
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
