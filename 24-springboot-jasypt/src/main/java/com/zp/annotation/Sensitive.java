package com.zp.annotation;


import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zp.enums.SensitiveStrategy;
import com.zp.model.SensitiveJsonSerializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Sensitive
 * 自定义jackson注解,标注在属性上,一旦有属性被标注,则进行对应得脱敏
 * @author zhengpanone
 * @since 2021-09-03
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@JsonSerialize(using = SensitiveJsonSerializer.class)
public @interface Sensitive {
    // 脱敏策略
    SensitiveStrategy strategy();
}
