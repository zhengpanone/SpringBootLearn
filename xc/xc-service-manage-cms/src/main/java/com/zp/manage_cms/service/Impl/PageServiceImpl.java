package com.zp.manage_cms.service.Impl;

import com.zp.cms.CmsPage;
import com.zp.cms.request.QueryPageRequest;
import com.zp.manage_cms.dao.CmsPageRepository;
import com.zp.manage_cms.service.PageService;
import com.zp.model.response.CommonCode;
import com.zp.model.response.QueryResponseResult;
import com.zp.model.response.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    CmsPageRepository cmsPageRepository;

    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        if (page < 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(all.getContent());//数据列
        queryResult.setTotal(all.getTotalElements());//记录总数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);

        return queryResponseResult;
    }


}
