package com.zp.api.cms;

import com.zp.model.request.QueryProjectRequest;
import com.zp.response.QueryResponseResult;

public interface CmsProjectControllerApi {
    //项目查询
    public QueryResponseResult findList(int page, int size, QueryProjectRequest queryProjectRequest);
}
