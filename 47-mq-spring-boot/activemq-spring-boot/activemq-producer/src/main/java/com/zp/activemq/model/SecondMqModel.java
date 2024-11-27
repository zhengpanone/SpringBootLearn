package com.zp.activemq.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Author : zhengpanone
 * Date : 2024/10/25 12:22
 * Version : v1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SecondMqModel extends DefaultMqModel implements Serializable {
    private static final long serialVersionUID = 1L;
    public String remark;

}
