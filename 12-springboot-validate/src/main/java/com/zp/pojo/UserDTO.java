package com.zp.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * UserDTO
 *
 * @author zhengpanone
 * @since 2022-01-06
 */
@Data
public class UserDTO implements Serializable {
    // TODO https://mp.weixin.qq.com/s/T0cBGk2Vy2WiaBi2xKTycg
    @NotNull(message = "")
    private long id;
    private String userName;
    private String mobile;
    private String sex;
    private String email;
    private String password;
    private Date createTime;
}
