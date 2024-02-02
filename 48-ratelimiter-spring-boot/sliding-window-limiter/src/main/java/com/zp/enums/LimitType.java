package com.zp.enums;

/**
 * Author : zhengpanone
 * Date : 2024/2/1 11:28
 * Version : v1.0.0
 * Description: TODO
 */
public enum LimitType {
    /**
     * 默认限流策略，针对一个接口进行限流
     */
    DEFAULT,
    /**
     * 根据IP地址进行限流
     */
    IP;
}
