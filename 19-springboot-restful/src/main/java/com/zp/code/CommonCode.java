package com.zp.code;


import lombok.Getter;

/**
 * 0 请求成功
 * 99999 未知失败
 * 1开头为对通用错误信息
 * 2开头为输入参数错误
 * 3开头为业务调用错误
 * 4开头为数据库数据业务错误
 * 5开头为缓存调用错误
 * 基础返回码
 * BaseCode
 */
@Getter
public enum CommonCode {
    /**
     * 返回码
     */
    SUCCESS(0, "success"),
    FAIL(10000, "通用错误信息"),
    SIGN_FAIL(10001, "签名错误"),
    TIME_FAIL(10002, "时间戳超时错误"),
    TOKEN_FAIL(10003, "token错误"),
    AUTH_FAIL(10004, "权限不足"),

    PARAM_FAIL(20000, "参数错误"),
    PARAM_EMPTY_ERROR(20001, "参数为空"),
    PARAM_PATTERN_ERROR(20002, "参数格式不对"),

    FAILED(99999, "系统繁忙，请稍后再试.");
    /**
     * 错误码
     */
    private int code;
    /**
     * 错误信息
     */
    private String message;

    CommonCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
