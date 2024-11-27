package com.zp.vo;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Author : zhengpanone
 * Date : 2024/8/8 14:07
 * Version : v1.0.0
 * Description: TODO
 */
@Data
@Accessors(chain = true)
@Builder
public class ProductVO {
    private int id;
    private int categoryId;
    private String name;
    private String description;
    private float price;
}
