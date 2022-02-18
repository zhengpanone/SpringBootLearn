package com.zp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Member
 *
 * @author zhengpanone
 * @since 2021-09-22
 */
@Data
public class UserEntity implements Serializable {
    private Integer id;
    private String name;
}
