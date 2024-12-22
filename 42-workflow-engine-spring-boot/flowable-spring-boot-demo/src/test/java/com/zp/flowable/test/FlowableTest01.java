package com.zp.flowable.test;


import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.*;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.DeploymentQuery;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@DisplayName("流程引擎测试类01")
public class FlowableTest01 {
    private static ProcessEngineConfiguration configuration = null;

    @BeforeAll
    public static void setUpEach() {
        configuration = new StandaloneProcessEngineConfiguration();
        configuration.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        configuration.setJdbcUrl("jdbc:mysql://localhost:13306/flowable-learn?serverTimezone=GMT%2B8&useSSL=false&createDatabaseIfNotExist=true&characterEncoding=utf8");
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
        configuration.setJdbcUrl("jdbc:mysql://localhost:13306/flowable-learn?serverTimezone=GMT%2B8&useSSL=false&createDatabaseIfNotExist=true&characterEncoding=utf8");
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
    @ParameterizedTest
    @ValueSource(strings = {"2501"})
    public void testDeleteDeployment(String deploymentId) {
        // 1. 获取ProcessEngine对象
        ProcessEngine processEngine = configuration.buildProcessEngine();
        // 2.获取RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.deleteDeployment(deploymentId, true);
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
        Deployment deployment = deploymentQuery.deploymentId(deploymentId).singleResult();
        Assertions.assertNotNull(deployment);
        log.info("Deployment ID: {}", deployment.getId());
        log.info("Deployment Name: {}", deployment.getName());
        log.info("Deployment Time: {}", deployment.getDeploymentTime());
        log.info("-----------------------------------------------------");
    }

    @Test
    @DisplayName("启动流程实列")
    public void testRunProcess() {
        ProcessEngine processEngine = configuration.buildProcessEngine();
        // 通过runTimeService来启动流程实例
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 构建流程变量
        Map<String, Object> variables = new HashMap<>();
        variables.put("employee", "张三");
        variables.put("nrOfHolidays", 3);
        variables.put("description", "工作累了，出去玩玩");
        // 启动流程实例
        ProcessInstance holidayRequest = runtimeService.startProcessInstanceByKey("holidayRequest", variables);
        log.info("ProcessInstance ProcessDefinitionId: {}", holidayRequest.getProcessDefinitionId());
        log.info("ProcessInstance ActivityId: {}", holidayRequest.getActivityId());
        log.info("ProcessInstance BusinessKey: {}", holidayRequest.getBusinessKey());
        log.info("ProcessInstance Id: {}", holidayRequest.getId());
    }


    @Test
    @DisplayName("查询任务")
    public void testQueryTask() {
        ProcessEngine processEngine = configuration.buildProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery()
                // 指定查询的流程编号
                .processDefinitionKey("holidayRequest")
                // 查询这个任务的处理人
                .taskAssignee("zhangsan")
                .list();
        for (Task task : list) {
            log.info("Task ID: {}", task.getId());
            log.info("Task Name: {}", task.getName());
            log.info("Task Description: {}", task.getDescription());
            log.info("Task Assignee: {}", task.getAssignee());
            log.info("Task ProcessDefinitionId: {}", task.getProcessDefinitionId());
        }
    }

    @Test
    @DisplayName("完成当前任务")
    public void testCompleteTask() {
        ProcessEngine processEngine = configuration.buildProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holidayRequest")
                .taskAssignee("zhangsan")
                .singleResult();
        // 创建流程变量
        Map<String, Object> variables = new HashMap<>();
        variables.put("approved", false);
        // 完成任务
        taskService.complete(task.getId(), variables);


    }

}
