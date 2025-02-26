package com.zp.webflux.r2dbc.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Author : zhengpanone
 * Date : 2025/2/26 10:28
 * Version : v1.0.0
 * Description:
 */
@Table("T_USERS")
@Data
public class Users {
    @Id
    private Long id;
    private String name;
    private String sex;
    private Integer age;
    private String firstname;
    private String lastname;
    @Version
   private Long version;
}
