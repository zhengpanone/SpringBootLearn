package com.zp.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Author : zhengpanone
 * Date : 2024/2/1 13:59
 * Version : v1.0.0
 * Description: 全局异常
 */
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(RateLimitException.class)
    public Map rateLimit(RateLimitException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", e.getCode());
        map.put("message", e.getMsg());
        return map;
    }
}
