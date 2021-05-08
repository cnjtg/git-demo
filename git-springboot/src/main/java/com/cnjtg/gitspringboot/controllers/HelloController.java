package com.cnjtg.gitspringboot.controllers;

import com.cnjtg.gitspringboot.beans.Results;
import com.cnjtg.gitspringboot.beans.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author cnjtg
 * @version 1.0
 * @slogin study hard and make progress every day
 * @date 2021-05-07 18:33
 */
@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "hello,world!";
    }

    @GetMapping("/getUser")
    public Results getUser(){
        User user  = new User();
        user.setUsername(UUID.randomUUID().toString());
        user.setUsername("tom");
        user.setPassword("1234");
        user.setAddress("广州");
        return Results.SUCCESS("成功！",user);
    }
}
