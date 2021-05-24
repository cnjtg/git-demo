package com.cnjtg.gitspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-07 18:33
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/index")
    public String index(ModelMap model) {
        model.addAttribute("username","tom");
        return "index";
    }

}
