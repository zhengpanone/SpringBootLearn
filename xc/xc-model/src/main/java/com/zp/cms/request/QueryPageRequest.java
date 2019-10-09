package com.zp.cms.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 接收页面查询条件
 */
@Data// 会为类的所有属性自动生成setter/getter、equals、canEqual、hashCode、toString方法
public class QueryPageRequest {

    @ApiModelProperty(value = "站点Id")
    private String siteId;
    @ApiModelProperty(value = "页面ID")
    private String pageId;
    @ApiModelProperty(value = "页面名称")
    private String pageName;
    @ApiModelProperty(value = "别名")
    private String pageAlias;
    @ApiModelProperty(value = "模板id")
    private String templateId;
}
