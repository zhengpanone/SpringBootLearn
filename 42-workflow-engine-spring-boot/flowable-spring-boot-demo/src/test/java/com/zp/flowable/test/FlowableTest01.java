package com.zp.flowable.test;


import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.DeploymentQuery;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

@Slf4j
@DisplayName("流程引擎测试类01")
public class FlowableTest01 {
    private static ProcessEngineConfiguration configuration = null;

    @BeforeAll
    public static void setUpEach() {
        configuration = new StandaloneProcessEngineConfiguration();
        configuration.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        configuration.setJdbcUrl("jdbc:mysql://localhost:3306/flowable-learn?serverTimezone=GMT%2B8&useSSL=false&createDatabaseIfNotExist=true&characterEncoding=utf8");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("root");
        // 如果数据库中的表结构不存在就新建数据表
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
    }

    @DisplayName("获取流程引擎对象")
    @Test
    public void testProcessEngine() {
        ProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();
        configuration.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        configuration.setJdbcUrl("jdbc:mysql://localhost:3306/flowable-learn?serverTimezone=GMT%2B8&useSSL=false&createDatabaseIfNotExist=true&characterEncoding=utf8");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("root");
        // 如果数据库中的表结构不存在就新建数据表
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 通过processEngineConfiguration构建需要的processEngine对象
        ProcessEngine processEngine = configuration.buildProcessEngine();
    }

    @DisplayName("创建部署流程")
    @Test
    public void testCreateDeployment() {
        // 1. 获取ProcessEngine对象
        ProcessEngine processEngine = configuration.buildProcessEngine();
        // 2.获取RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 3.完成流程的部署操作
        Deployment deploy = repositoryService
                .createDeployment()
                .addClasspathResource("holiday-request.bpmn20.xml")
                .name("请假流程")
                .deploy();

        log.info("deploy.getId() = {}", deploy.getId());
        log.info("deploy.getName() = {}", deploy.getName());
    }

    @DisplayName("删除部署流程")
    @Test
    public void testDeleteDeployment() {
        // 1. 获取ProcessEngine对象
        ProcessEngine processEngine = configuration.buildProcessEngine();
        // 2.获取RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.deleteDeployment("1", true);
    }

    @DisplayName("查询所有的部署流程")
    @Test
    public void testListDeployment() {
        ProcessEngine processEngine = configuration.buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentQuery deploymentQuery = repositoryService.createDeploymentQuery();
        // 查询所有的部署流程
        List<Deployment> deployments = deploymentQuery.list();
        // 输出所有部署的信息
        for (Deployment deployment : deployments) {
            log.info("Deployment ID: {}", deployment.getId());
            log.info("Deployment Name: {}", deployment.getName());
            log.info("Deployment Time: {}", deployment.getDeploymentTime());
            log.info("-----------------------------------------------------");
        }
    }

    @DisplayName("查询部署流程信息")
    @ParameterizedTest
    @ValueSource(strings = {"2501"})
    public void testQueryDeployment(String deploymentId) {
        ProcessEngine processEngine = configuration.buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentQuery deploymentQuery = repositoryService.createDeploymentQuery();
        // 查询所有的部署流程
        Deployment deployment = deploymentQuery.deploymentId("2501").singleResult();
        Assertions.assertNotNull(deployment);
        log.info("Deployment ID: {}", deployment.getId());
        log.info("Deployment Name: {}", deployment.getName());
        log.info("Deployment Time: {}", deployment.getDeploymentTime());
        log.info("-----------------------------------------------------");
    }

}
