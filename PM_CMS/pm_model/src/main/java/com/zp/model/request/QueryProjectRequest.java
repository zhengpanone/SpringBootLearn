package com.zp.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryProjectRequest {
    //接收项目查询条件
    @ApiModelProperty("项目ID")
    private String projectId;
    @ApiModelProperty("项目名称")
    private String projectName;
    @ApiModelProperty("样本名称")
    private String sampleName;
    //。。。。


}
