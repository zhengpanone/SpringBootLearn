package com.zp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/07/22 16:50.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String username;
    private String password;
}
