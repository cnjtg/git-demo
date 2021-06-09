package com.cnjtg;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class GroupTaskTest {

    private static final String LEAVE = "Holiday5";


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
                .addClasspathResource("diagram/holiday5.bpmn")
                .name("请假流程-分组任务")
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



        ProcessInstance process = runtimeService.startProcessInstanceByKey(LEAVE, "1004");

        System.out.println("流程ID= " + process.getId());
        System.out.println("流程ID= " + process.getProcessDefinitionId());
        System.out.println("活动ID= " + process.getActivityId());
    }

    /**
     * 拾取任务 （claim 接取任务，setAssignee（id,null） 归还任务）
     * 此方法需要在main中执行,否则会和security冲突
     */
    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = engine.getTaskService();

        String candidate_users = "lisi";

        List<Task> list = taskService.createTaskQuery()
                .processInstanceBusinessKey("1004")
                .taskCandidateUser(candidate_users)
                .list();

        list.forEach(task -> {
            System.out.println(task.getId());
            System.out.println(task.getName());
            System.out.println(task.getAssignee());
        });

        list.forEach(task -> {
            taskService.claim(task.getId(),candidate_users);
            System.out.println(candidate_users +"拾取了["+task.getName()+"]任务");
        });

        list.forEach(task -> {
            //将该任务处理人设置为空，相当于归还到组成员
            taskService.setAssignee(task.getId(),null);
            System.out.println(candidate_users + "归还了["+task.getName()+"]任务");
        });
    }

    /**
     * 处理任务
     */
    @Test
    void dealTask() {

        String taskAssignee = "xiaozhang";

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