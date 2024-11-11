package com.zp.activemq.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Author : zhengpanone
 * Date : 2024/10/25 12:20
 * Version : v1.0.0
 */
@Data
public class DefaultMqModel implements Serializable {
    private static final long serialVersionUID = 1L;
    public String title;
    public String content;
    public Integer type;


}
