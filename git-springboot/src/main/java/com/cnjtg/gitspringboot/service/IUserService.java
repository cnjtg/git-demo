package com.cnjtg.gitspringboot.service;

import com.cnjtg.gitspringboot.entity.User;

import java.util.List;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-11 16:46
 */
public interface IUserService {

    /**
     * 列表
     * @return
     */
    List<User> listUser();

    /**
     * 获取单个
     * @param uuid
     * @return
     */
    User get(String uuid);

    /**
     * 保存
     * @param user
     */
    void save(User user);
}
