package com.zp.manage_cms.dao;

import com.zp.model.cms.CmsPooling;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsPoolingRepository extends MongoRepository<CmsPooling, String> {
    //根据pooling单名称查询
    CmsPooling findByPoolingName(String poolingName);

}
