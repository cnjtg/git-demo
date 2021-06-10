package com.cnjtg.base;

import com.cnjtg.entity.Holiday;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class VariableTest {

    @Autowired
    private RepositoryService repositoryService;

    private static final String LEAVE = "Holiday";


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
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday.bpmn")
                .addClasspathResource("diagram/holiday.png")
                .name("请假流程-流程变量")
                .deploy();

        System.out.println("流程ID = " + deploy.getId());
        System.out.println("流程Name = " + deploy.getName());
    }


    /**
     * 启动流程
     */
    @Test
    void startActiviti() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = engine.getRuntimeService();


        Map<String, Object> params = new HashMap<>();

        Holiday holiday = new Holiday();
        holiday.setId(1);
        holiday.setUsername("tom");
        //根据holiday.num的值改变流程的环节
        holiday.setNum(1.0F);
        holiday.setStartDate(new Date());
        params.put("holiday", holiday);


        ProcessInstance process = runtimeService.startProcessInstanceByKey(LEAVE, holiday.getId().toString(), params);

        System.out.println("流程ID= " + process.getId());
        System.out.println("流程ID= " + process.getProcessDefinitionId());
        System.out.println("流程部署ID= " + process.getDeploymentId());
        System.out.println("活动ID= " + process.getActivityId());
    }

    @Test
    void dealTask() {

        String taskAssignee = "zhaoliu";

        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = engine.getTaskService();
        List<Task> list = taskService.createTaskQuery().taskAssignee(taskAssignee).list();

        list.forEach(task -> {
            String taskId = task.getId();
            taskService.complete(taskId);
            System.out.println("( "+task.getAssignee()+" ) 完成了 ["+task.getName()+" ]任务");
        });
    }


}