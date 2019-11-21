package com.zp.manage_cms.dao;

import com.zp.model.cms.CmsProject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CmsProjectRepository extends MongoRepository<CmsProject, String> {
    //根据任务单名称查询
    List<CmsProject> findByProjectName( String projectName);

    //根据任务单名称和样本名称查询
    CmsProject findByProjectNameAndSampleName(String projectName, String sampleName);

    // 根据pooling单名称和任务单名称分页查询
    Page<CmsProject> findByPoolingNameAndProjectName(String poolingName, String projectName, Pageable pageable);

}
