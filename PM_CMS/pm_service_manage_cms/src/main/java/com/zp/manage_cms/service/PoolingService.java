package com.zp.manage_cms.service;

import com.zp.manage_cms.dao.CmsPoolingRepository;
import com.zp.model.cms.CmsPooling;
import com.zp.model.response.CmsPoolingResult;
import com.zp.response.CommonCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoolingService {
    @Autowired
    CmsPoolingRepository cmsPoolingRepository;

    public CmsPoolingResult addPooling(CmsPooling cmsPooling) {
        CmsPooling byPoolingName = cmsPoolingRepository.findByPoolingName(cmsPooling.getPoolingName());
        if (byPoolingName == null) {
            cmsPooling.setId(null);
            cmsPoolingRepository.save(cmsPooling);
            return new CmsPoolingResult(CommonCode.SUCCESS, cmsPooling);
        }
        return new CmsPoolingResult(CommonCode.FAIL, null);

    }
}
