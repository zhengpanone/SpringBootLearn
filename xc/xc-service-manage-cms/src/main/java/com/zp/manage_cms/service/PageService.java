package com.zp.manage_cms.service;

import com.zp.cms.request.QueryPageRequest;
import com.zp.model.response.QueryResponseResult;

public interface PageService {
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
}
