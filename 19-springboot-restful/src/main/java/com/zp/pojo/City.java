package com.zp.pojo;

import lombok.Data;


@Data
public class City {
    private Long id;
    private Long provinceId;
    private String cityName;
    private String description;

}
