package com.cnjtg.gitspringboot.rest;

import com.cnjtg.gitspringboot.beans.Results;
import com.cnjtg.gitspringboot.entity.User;
import com.cnjtg.gitspringboot.service.IUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-08 15:21
 */
@Api(value = "用户管理")
@ApiResponses({@ApiResponse(code = 200, message = "success", response = Results.class)})
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
    @ApiOperation("修改用户方法")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true),
            @ApiImplicitParam(name = "address", value = "地址", required = true),
            @ApiImplicitParam(name = "id", value = "ID", required = true)
            })
    public Results updateUser(User user) {
        //TODO 修改用户
        return Results.SUCCESS();
    }

    @DeleteMapping("deleteUser")
    @ApiImplicitParam(name = "id", defaultValue = "默认是1")
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
