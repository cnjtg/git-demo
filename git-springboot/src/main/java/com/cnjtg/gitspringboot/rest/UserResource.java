package com.cnjtg.gitspringboot.rest;

import com.cnjtg.gitspringboot.beans.Results;
import com.cnjtg.gitspringboot.entity.User;
import com.cnjtg.gitspringboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-08 15:21
 */
@RestController
@RequestMapping("/rest/user")
public class UserResource {

    @Autowired
    IUserService userService;

    @GetMapping("/getUser")
    public Results getUser() {
        User user = new User();
        user.setUsername(UUID.randomUUID().toString());
        user.setUsername("tom");
        user.setPassword("1234");
        user.setAddress("广州");
        return Results.SUCCESS("成功！", user);
    }

    @PutMapping("updateUser")
    public Results updateUser(User user) {
        //TODO 修改用户
        return Results.SUCCESS();
    }

    @DeleteMapping("deleteUser")
    public Results deleteUser(String id) {

        return Results.SUCCESS();
    }

    @GetMapping("/listUser")
    public Results listUser() {
        List<User> list = userService.listUser();
        Results results = Results.SUCCESS();
        results.setData(list);
        return results;
    }
}
