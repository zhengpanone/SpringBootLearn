package com.zp.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/07/22 17:00.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private int code;
    private String msg;
    private Object data;
}
