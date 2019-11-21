package com.zp.manage_cms.service;

import com.zp.manage_cms.dao.CmsProjectRepository;
import com.zp.model.cms.CmsProject;
import com.zp.model.request.QueryProjectRequest;
import com.zp.response.CommonCode;
import com.zp.response.QueryResponseResult;
import com.zp.response.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

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
        if (queryProjectRequest == null) {
            queryProjectRequest = new QueryProjectRequest();
        }
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withMatcher("poolingName", ExampleMatcher.GenericPropertyMatchers.contains());

        CmsProject cmsProject = new CmsProject();
        if (StringUtils.isNotEmpty(queryProjectRequest.getProjectId())) {
            cmsProject.setId(queryProjectRequest.getProjectId());
        }
        if (StringUtils.isNotEmpty(queryProjectRequest.getProjectName())) {
            cmsProject.setProjectName(queryProjectRequest.getProjectName());
        }
        if (StringUtils.isNotEmpty(queryProjectRequest.getSampleName())) {
            cmsProject.setSampleName(queryProjectRequest.getSampleName());
        }

        Example<CmsProject> example = Example.of(cmsProject, exampleMatcher);

        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(page, size);

        Page<CmsProject> all = cmsProjectRepository.findAll(example, pageable); //实现自定义条件查询并且分页查询
        QueryResult queryResult = new QueryResult();
        queryResult.setList(all.getContent()); //数据列表
        queryResult.setTotal(all.getTotalElements()); //数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);

        return queryResponseResult;

    }

}
