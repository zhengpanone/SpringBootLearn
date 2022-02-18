package com.zp.pojo;

import com.zp.enums.ResultStatus;
import lombok.Data;

/**
 * R
 *
 * @author zhengpanone
 * @since 2022-01-06
 */
@Data
public class ResultData<T> {
    private int status;
    private String message;
    private T data;
    private long timestamp;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }


    public static <T> ResultData<T> success(T data){
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ResultStatus.RS100.getCode());
        resultData.setMessage(ResultStatus.RS100.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> success(){
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ResultStatus.RS100.getCode());
        resultData.setMessage(ResultStatus.RS100.getMessage());
        return resultData;
    }

    public static <T> ResultData<T> fail(int code,String message){
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(code);
        resultData.setMessage(message);
        return resultData;
    }
}
