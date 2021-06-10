package com.cnjtg;

import com.cnjtg.activiti.SecurityUtil;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-10 16:04
 */
@SpringBootTest
public class ActivitiSpringBootTest {
    @Autowired
    private ProcessRuntime processRuntime;

    @Autowired
    private TaskRuntime taskRuntime;

    @Autowired
    private SecurityUtil securityUtil;


    /**
     * 自动部署流程后查询流程（bpmn放入processes中会自动部署）
     */
    @Test
    void definition(){
        securityUtil.logInAs("salaboy");
        Page<ProcessDefinition> definitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
        System.out.println(definitionPage.getTotalItems());

        definitionPage.getContent().forEach(System.out::println);
    }

    /**
     * 启动流程
     */
    @Test
    void start(){
        securityUtil.logInAs("salaboy");
        ProcessInstance process = processRuntime.start(ProcessPayloadBuilder.start()
                .withProcessDefinitionKey("myProcess_1")
                .withBusinessKey("1001")
                .withName("请假流程")
                .build());


        System.out.println("流程ID= " + process.getId());
        System.out.println("流程ID= " + process.getProcessDefinitionId());
    }

    /**
     * 查询任务
     */
    @Test
    void query(){
        securityUtil.logInAs("erdemedeiros");
        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));//分页查询任务
        if(tasks.getTotalItems() == 0) return;

        tasks.getContent().forEach(System.out::println);

    }

    /**
     * 处理任务
     */
    @Test
    void deal(){
        //第一环节处理任务
//        securityUtil.logInAs("ryandawsonuk");
//        String taskId = "28ec3c4e-c9c6-11eb-8573-024238cdf2da";
        //第二环节处理任务
        securityUtil.logInAs("erdemedeiros");
        String taskId = "e45172c4-c9c7-11eb-8e38-024238cdf2da";

        taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(taskId).build());

        taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(taskId).build());
    }
}
