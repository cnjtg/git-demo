package com.cnjtg.gitspringboot;

import com.cnjtg.gitspringboot.beans.Bean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GitSpringbootApplicationTests {


    @Autowired
    private Bean bean;

    @Test
    void contextLoads() {
        System.out.println(bean.toString());
    }


}
