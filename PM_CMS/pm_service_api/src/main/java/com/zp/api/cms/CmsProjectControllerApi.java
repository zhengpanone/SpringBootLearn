package com.zp.api.cms;

import com.zp.model.request.QueryProjectRequest;
import com.zp.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "项目管理接口", description = "项目管理cms接口,提供增、删、改、查")
public interface CmsProjectControllerApi {
    //项目查询
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int")
    })
    public QueryResponseResult findList(int page, int size, QueryProjectRequest queryProjectRequest);
}
