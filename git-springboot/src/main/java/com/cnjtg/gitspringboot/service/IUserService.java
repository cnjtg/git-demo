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
     *
     * @return {@link List<User>}
     */
    List<User> listUser();

    /**
     * 获取单个
     *
     * @param uuid uuid
     * @return {@link User}
     */
    User get(String uuid);

    /**
     * 保存
     *
     * @param user 用户
     */
    void save(User user);
}
