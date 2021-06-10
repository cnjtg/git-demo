package com.cnjtg.base;

import org.activiti.engine.*;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipInputStream;

@SpringBootTest
class ActivitiApplicationTests2 {

    private static final String LEAVE = "leave2";


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
                .addClasspathResource("diagram/leave2.bpmn")
                .addClasspathResource("diagram/leave2.png")
                .name("请假流程2").deploy();

        System.out.println("流程ID = " + deploy.getId());
        System.out.println("流程Name = " + deploy.getName());
    }


    /**
     * 启动流程
     * 1、${}配置assignee的值
     * 2、类方式
     *      <UserTask>
     *         <extensionElements>
     *             <activiti:taskListener event="create" class="com.cnjtg.base.AssigneeListener"/>-->
     *         </extensionElements>
     *      </UserTask>
     *  使用监听类传值
     */
    @Test
    void startActiviti(){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = engine.getRuntimeService();

        Map<String,Object> param = new HashMap<>();
        param.put("assignee0","zhangsan1");
        param.put("assignee1","lisi1");
        param.put("assignee2","wangwu1");

        ProcessInstance process = runtimeService.startProcessInstanceByKey(LEAVE, "1001", param);

        System.out.println("流程ID= " + process.getId());
        System.out.println("流程ID= " + process.getProcessDefinitionId());
        System.out.println("流程部署ID= " + process.getDeploymentId());
        System.out.println("活动ID= " + process.getActivityId());
    }


}

class AssigneeListener  implements TaskListener{

    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("zhangsan");
    }
}