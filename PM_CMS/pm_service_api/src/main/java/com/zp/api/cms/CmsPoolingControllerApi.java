package com.zp.api.cms;

import com.zp.model.cms.CmsPooling;
import com.zp.model.response.CmsPoolingResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "pooling单管理接口", description = "pooling单管理接口,提供增、删、改、查")
public interface CmsPoolingControllerApi {

    @ApiOperation("新增pooling单")
    public CmsPoolingResult add(CmsPooling cmsPooling);

}
