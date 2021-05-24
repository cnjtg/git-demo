package com.cnjtg.gitspringboot.service.impl;

import com.cnjtg.gitspringboot.entity.User;
import com.cnjtg.gitspringboot.mapper.UserMapper;
import com.cnjtg.gitspringboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-11 16:47
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> listUser() {
        return userMapper.list();
    }

    @Override
    public User get(String uuid) {
        return userMapper.getById(uuid);
    }

    @Override
    public void save(User user) {
        userMapper.saveUser(user);
    }
}
