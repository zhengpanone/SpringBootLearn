package com.zp.manage_cms.controller;

import com.zp.api.cms.CmsPoolingControllerApi;
import com.zp.manage_cms.service.PoolingService;
import com.zp.model.cms.CmsPooling;
import com.zp.model.response.CmsPoolingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cms/pooling")
public class CmsPoolingController implements CmsPoolingControllerApi {
    @Autowired
    PoolingService poolingService;

    @Override
    @PostMapping("/add")
    public CmsPoolingResult add(@RequestBody CmsPooling cmsPooling) {
        return poolingService.addPooling(cmsPooling);
    }
}
