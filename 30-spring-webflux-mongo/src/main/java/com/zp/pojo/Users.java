package com.zp.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Users
 *
 * @author zhengpanone
 * @since 2022-01-18
 */
@Document(collection = "c-users")
@Data
public class Users {
    @Id
    private Long id;
    private String username;
    private String password;
    private Integer age;
    private String email;
}
