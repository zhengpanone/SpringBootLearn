package com.zp.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryPoolingRequest {
    @ApiModelProperty("pooling单ID")
    private String poolingId;
    @ApiModelProperty("pooling单名称")
    private String poolingName;
    @ApiModelProperty("是否外包")
    private String isOutBusiness;
}
