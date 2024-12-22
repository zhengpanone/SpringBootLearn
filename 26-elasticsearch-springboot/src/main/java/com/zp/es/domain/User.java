package com.zp.es.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author : zhengpanone
 * Date : 2024/12/22 11:02
 * Version : v1.0.0
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userName;
    private String age;
    private String gender;
}
