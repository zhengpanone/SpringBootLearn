package com.zp.manage_cms.dao;

import com.zp.model.cms.CmsProject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsProjectRepositoryTest {
    @Autowired
    CmsProjectRepository cmsProjectRepository;

    @Test
    public void testFindAll() {
        List<CmsProject> all = cmsProjectRepository.findAll();
        System.out.println(all);

    }

    //分页查询
    @Test
    public void testFindPage() {
        //分页参数
        int page = 0;//从0开始
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsProject> all = cmsProjectRepository.findAll(pageable);
        System.out.println(all);
    }

    @Test
    public void testInsert() {
        CmsProject cmsProject = new CmsProject();
        cmsProject.setProjectName("test project name");
        cmsProject.setPoolingName("test pooling name");
        cmsProjectRepository.save(cmsProject);
        System.out.println(cmsProject);

    }

    @Test
    public void testUpdate() {
        //查询对象
        Optional<CmsProject> optional = cmsProjectRepository.findById("5dd38b2907000cab386af0c8");
        if (optional.isPresent()) {
            CmsProject cmsProject = optional.get();
            cmsProject.setPoolingName("pooling单名称");
            CmsProject save = cmsProjectRepository.save(cmsProject);
            System.out.println(save);
        }
    }
}
