package com.zp.manage_cms.dao;

import com.zp.model.cms.CmsProject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
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
        cmsProjectRepository.save(cmsProject);
        System.out.println(cmsProject);

    }

    @Test
    public void testUpdate() {
        //查询对象
        Optional<CmsProject> optional = cmsProjectRepository.findById("5dd38b2907000cab386af0c8");
        if (optional.isPresent()) {
            CmsProject cmsProject = optional.get();
            CmsProject save = cmsProjectRepository.save(cmsProject);
            System.out.println(save);
        }
    }

    @Test
    public void testFindByProjectName() {
        List<CmsProject> test_project_name = cmsProjectRepository.findByProjectName("test project name");
        System.out.println(test_project_name);
    }

    @Test
    public void testFindAllByExample() {
        int page = 0; //从0开始
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);

        //条件值对象
        CmsProject cmsProject = new CmsProject();

        //定义Example
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        //定义条件匹配器
        exampleMatcher = exampleMatcher.withMatcher("poolingName", ExampleMatcher.GenericPropertyMatchers.contains());
        //包含 contains() 区分大小写 caseSensitive() 以结尾 endWith()

        Example<CmsProject> example = Example.of(cmsProject, exampleMatcher);
        Page<CmsProject> all = cmsProjectRepository.findAll(example, pageable);
        List<CmsProject> content = all.getContent();
        System.out.println(content);

    }
}
