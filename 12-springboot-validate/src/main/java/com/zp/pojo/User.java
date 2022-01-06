package com.zp.pojo;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
public class User {

    private Integer id;
    @NotNull(message = "用户名不能为空")
    @Length(min = 2, max = 12)
    private String name;
    @NotNull(message = "密码不能为空")
    private Integer age;

}
