package com.zp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author : zhengpanone
 * Date : 2024/2/1 13:59
 * Version : v1.0.0
 * Description: 自定义限流异常
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateLimitException extends RuntimeException {
    private Integer code;
    private String msg;
}
