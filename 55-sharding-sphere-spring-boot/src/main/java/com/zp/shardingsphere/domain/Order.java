package com.zp.shardingsphere.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * Author : zhengpanone
 * Date : 2025/2/25 09:47
 * Version : v1.0.0
 * Description:
 */
@Data
@TableName("t_order")
public class Order extends Model<Order> {
    @TableId(type = IdType.ASSIGN_ID)
    private Long orderId;

    private Integer userId;

    private String orderName;

    @Override
    public Serializable pkVal() {
        return this.orderId;
    }
}
