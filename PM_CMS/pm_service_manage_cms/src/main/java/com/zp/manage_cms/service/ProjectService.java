package com.zp.manage_cms.service;

import com.zp.manage_cms.dao.CmsProjectRepository;
import com.zp.model.cms.CmsProject;
import com.zp.model.request.QueryProjectRequest;
import com.zp.response.CommonCode;
import com.zp.response.QueryResponseResult;
import com.zp.response.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    CmsProjectRepository cmsProjectRepository;

    /**
     * @param page                页码从1开始计数
     * @param size                每页记录数
     * @param queryProjectRequest
     * @return
     */

    public QueryResponseResult findList(int page, int size, QueryProjectRequest queryProjectRequest) {
        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsProject> all = cmsProjectRepository.findAll(pageable);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(all.getContent()); //数据列表
        queryResult.setTotal(all.getTotalElements()); //数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);

        return queryResponseResult;

    }

}
