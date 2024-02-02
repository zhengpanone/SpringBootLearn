package com.zp.annotation;

import com.zp.enums.LimitType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author : zhengpanone
 * Date : 2024/2/1 11:23
 * Version : v1.0.0
 * Description: TODO
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RateLimiter {
    /**
     * 定义redis中限流key前缀， rate_limit: com.xxx.controller.HelloController-hello // HelloController中的hello方法
     */
    String key() default "rate_limit";

    /**
     * 限流时间，单位秒
     */
    int time() default 60;

    /**
     * 限流时间内限流次数
     */

    int count() default 100;

    /**
     * 限流类型：1.限制接口访问次数，2，限制ip访问次数
     */

    LimitType limitType() default LimitType.DEFAULT;
}
