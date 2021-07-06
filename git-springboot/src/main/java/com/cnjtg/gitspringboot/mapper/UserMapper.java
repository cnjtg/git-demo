package com.cnjtg.gitspringboot.mapper;

import com.cnjtg.gitspringboot.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-11 16:47
 */
public interface UserMapper {

    /**
     * 列表
     *
     * @return {@link List<User>}
     */
    List<User> list();


    /**
     * 保存用户
     *
     * @param user 用户
     */
    void saveUser(@Param("user") User user);

    /**
     * 通过id
     *
     * @param uuid uuid
     * @return {@link User}
     */
    User getById(String uuid);

}
