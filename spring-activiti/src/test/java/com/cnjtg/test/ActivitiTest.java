package com.cnjtg.test;

import org.activiti.engine.RepositoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-10 14:03
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:activiti-spring.xml")
public class ActivitiTest {

    @Autowired
    private RepositoryService repositoryService;

    @Test
    void deployment() {

    }
}
