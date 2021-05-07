package com.cnjtg.gitspringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cnjtg
 * @version 1.0
 * @className HelloController
 * @date 2021-05-07 18:23
 */
@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "hello,world!";
    }
}
