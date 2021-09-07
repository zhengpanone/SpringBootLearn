package com.zp.model;

import com.zp.annotation.Sensitive;
import com.zp.enums.SensitiveStrategy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Person
 *
 * @author zhengpanone
 * @since 2021-09-18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    /**
     * 真实姓名
     */
    @Sensitive(strategy = SensitiveStrategy.USERNAME)
    private String realName;
    /**
     * 地址
     */
    @Sensitive(strategy = SensitiveStrategy.ADDRESS)
    private String address;
    /**
     * 电话号码
     */
    @Sensitive(strategy = SensitiveStrategy.PHONE)
    private String phoneNumber;

    @Sensitive(strategy = SensitiveStrategy.ID_CARD)
    private String idCard;
}
