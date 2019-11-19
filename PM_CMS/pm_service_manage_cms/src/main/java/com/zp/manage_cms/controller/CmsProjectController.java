package com.zp.manage_cms.controller;

import com.zp.api.cms.CmsProjectControllerApi;
import com.zp.manage_cms.service.ProjectService;
import com.zp.model.request.QueryProjectRequest;
import com.zp.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cms/project")
public class CmsProjectController implements CmsProjectControllerApi {

    @Autowired
    ProjectService projectService;

    /**
     * http://localhost:8080/cms/project/list/1/2
     *
     * @param page 页码
     * @param size 每页数据量
     * @return QueryResponseResult
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size,
                                        QueryProjectRequest queryProjectRequest) {
        /*QueryResult<CmsProject> queryResult = new QueryResult<>();
        List<CmsProject> list = new ArrayList<>();
        CmsProject cmsProject = new CmsProject();
        cmsProject.setProjectName("test");
        list.add(cmsProject);
        queryResult.setList(list);
        queryResult.setTotal(1);
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);

        return queryResponseResult;*/
        return projectService.findList(page, size, queryProjectRequest);
    }
}
