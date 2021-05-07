package com.cnjtg.gitspringboot;

import com.cnjtg.gitspringboot.beans.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GitSpringbootApplicationTests {


    @Autowired
    private User user;

    @Test
    void contextLoads() {
        System.out.println(user.toString());
    }


}
