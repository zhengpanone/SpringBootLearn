package com.zp.response;

import com.zp.code.CommonCode;
import lombok.Data;

import java.io.Serializable;

/**
 * ApiResult
 *
 * @author zhengpanone
 * @since 2022-09-20
 */
@Data
public class ApiResult<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    protected ApiResult() {

    }

    protected ApiResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    protected ApiResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResult<T> success() {
        return new ApiResult<>(CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMessage());
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMessage(), data);
    }

    public static <T> ApiResult<T> failed(CommonCode commonCode) {
        return new ApiResult<>(commonCode.getCode(), commonCode.getMessage(), null);
    }

    public static <T> ApiResult<T> failed(String message) {
        return new ApiResult<>(CommonCode.FAILED.getCode(), message, null);
    }

    public static <T> ApiResult<T> failed(CommonCode commonCode, String message) {
        return new ApiResult<>(commonCode.getCode(), message, null);
    }

    public static <T> ApiResult<T> failed(int code, String message) {
        return new ApiResult<>(code, message, null);
    }
}
