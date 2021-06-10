package com.cnjtg.base;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipInputStream;

@SpringBootTest
class ActivitiApplicationTests {

    private static final String LEAVE = "leave";

    /**
     * 流程配置
     */
    @Test
    void contextLoads() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine engine = configuration.buildProcessEngine();

        TaskService taskService = engine.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery();
        List<Task> list = taskQuery.list();

        System.out.println(list);

    }

    /**
     * 流程定义和部署
     * act_re_deployment
     * act_re_procdef
     * act_re_bytearray
     * 一个流程定义可以对应多少流程实例
     */
    @Test
    void deployActiviti() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = engine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment().addClasspathResource("diagram/leave.bpmn").addClasspathResource("diagram/leave.png").name("请假流程").deploy();

        System.out.println("流程ID = " + deploy.getId());
        System.out.println("流程Name = " + deploy.getName());
    }

    /**
     * zip文件部署
     */
    @Test
    void deployZipActiviti() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("diagram/leave.zip");
        assert inputStream != null;
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        RepositoryService repositoryService = engine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment().addZipInputStream(zipInputStream).name("请假流程").deploy();

        System.out.println("流程ID = " + deploy.getId());
        System.out.println("流程Name = " + deploy.getName());
    }

    /**
     * 启动流程实例
     * 1、得到ProcessEngine
     * 2、得到RunService
     * 3、通过bpmn的Id 启动流程
     */
    @Test
    void startActiviti() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = engine.getRuntimeService();

        //用于关联业务唯一的
        String businessKey = "1001";

        ProcessInstance process = runtimeService.startProcessInstanceByKey(LEAVE, businessKey);

        System.out.println("流程ID= " + process.getId());
        System.out.println("流程ID= " + process.getProcessDefinitionId());
        System.out.println("流程部署ID= " + process.getDeploymentId());
        System.out.println("活动ID= " + process.getActivityId());
    }

    /**
     * 查询用户任务列表
     */
    @Test
    void queryTask() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = engine.getTaskService();

        String taskAssignee = "zhangsan1";
        List<Task> list = taskService.createTaskQuery().taskAssignee(taskAssignee).list();


        list.forEach(task -> {
            System.out.println("任务ID = " + task.getId());
            System.out.println("任务Name = " + task.getName());
            System.out.println("任务负责人 = " + task.getAssignee());
            System.out.println("流程实例ID = " + task.getProcessInstanceId());

        });

    }

    /**
     * 查询某人的单个任务 并处理，通过或不通过
     * act_ru_task 表中记录当前需要处理的环节
     */

    @Test
    void dealTask() {

        String taskAssignee = "zhangsan1";

        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = engine.getTaskService();
        List<Task> list = taskService.createTaskQuery().taskAssignee(taskAssignee).list();

        list.forEach(task -> {
            String taskId = task.getId();
            taskService.complete(taskId);
        });
    }

    /**
     * 流程处理历史
     */
    @Test
    void historyTask() {
        String ProcessInstanceId = "7763f168-c81c-11eb-870c-024238cdf2da";
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();


        HistoryService historyService = engine.getHistoryService();
        HistoricActivityInstanceQuery historicActivityInstanceQuery = historyService.createHistoricActivityInstanceQuery();
        historicActivityInstanceQuery.orderByHistoricActivityInstanceStartTime().asc();
        historicActivityInstanceQuery.processInstanceId(ProcessInstanceId);
        List<HistoricActivityInstance> list = historicActivityInstanceQuery.list();

        list.stream().filter(instance -> instance.getAssignee() != null).collect(Collectors.toList()).forEach(instance -> {

            Date endTime = instance.getEndTime();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");
            String end = df.format(endTime);

            System.out.print("[" + instance.getAssignee() + "] {" + end + "} 推进了ID为【");
            System.out.print(instance.getId());
            System.out.println("】---- " + instance.getActivityName() + " ---的任务");
        });
    }


    //---------------------------------------------------------------------------------------------------------------

    /**
     * 流程定义信息查询
     */
    @Test
    void taskDefinitionHistory() {
        String definitionKey = "leave";
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = engine.getRepositoryService();
        ProcessDefinitionQuery definitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> list = definitionQuery.processDefinitionKey(definitionKey).orderByProcessDefinitionVersion().asc().list();
        list.forEach(process -> {
            System.out.println("流程定义ID : " + process.getId());
            System.out.println("流程定义名称 : " + process.getName());
            System.out.println("流程定义的Key : " + process.getKey());
            System.out.println("流程定义的版本 : " + process.getVersion());
        });
    }

    /**
     * 强行删除部署的流程
     * 参数为true 代表级联删除，会删除未完成的流程节点，
     */
    @Test
    void deleteDeployment() {
        String definitionKey = "leave";
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = engine.getRepositoryService();
        repositoryService.deleteDeployment(definitionKey, true);
    }


    /**
     * 通过任务获取资源文件
     */
    @Test
    void activitiSource() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = engine.getRepositoryService();

        ProcessDefinitionQuery definitionQuery = repositoryService.createProcessDefinitionQuery();
        //流程定义的key
        List<ProcessDefinition> list = definitionQuery.processDefinitionKey("leave").list();


        list.forEach(def -> {
            InputStream resourceAsStream1 = repositoryService.getResourceAsStream(def.getDeploymentId(), def.getDiagramResourceName());
            InputStream resourceAsStream = repositoryService.getResourceAsStream(def.getDeploymentId(), def.getResourceName());

        });
    }

    /**
     * 流程挂起和激活
     */
    @Test
    void suspendProcess() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = engine.getRepositoryService();
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("leave")
                .list();
        list.forEach(leave -> {
            boolean suspended = leave.isSuspended();
            if (suspended) {
                //激活实例
                repositoryService.activateProcessDefinitionById(leave.getId(), true, null);
                System.out.println(leave.getId() + " 被激活");
            } else {
                //挂起实例
                repositoryService.suspendProcessDefinitionById(leave.getId(), true, null);
                System.out.println(leave.getId() + " 被挂起");
            }
        });


    }
}
