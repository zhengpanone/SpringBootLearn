package com.zp.enums;

import lombok.Data;
import lombok.Getter;


/**
 * ResultStatus
 *
 * @author zhengpanone
 * @since 2022-01-06
 */
@Getter
public enum  ResultStatus {
    RS100(100,"操作成功"),
    RS999(999,"操作失败");

    private final int code;
    private final String message;
    ResultStatus(int code,String message){
        this.code= code;
        this.message = message;
    }


}
