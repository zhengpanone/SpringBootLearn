package com.zp.model.response;

import com.zp.model.cms.CmsPooling;
import com.zp.response.ResponseResult;
import com.zp.response.ResultCode;
import lombok.Data;

@Data
public class CmsPoolingResult extends ResponseResult {
    CmsPooling cmsPooling;

    public CmsPoolingResult(ResultCode resultCode, CmsPooling cmsPooling) {
        super(resultCode);
        this.cmsPooling = cmsPooling;
    }
}
