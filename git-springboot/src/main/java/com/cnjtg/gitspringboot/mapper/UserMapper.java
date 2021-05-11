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
     * @return
     */
    List<User> list();


    /**
     *
     * @param user
     */
    void saveUser(@Param("user") User user);

    /**
     *
     * @param uuid
     * @return
     */
    User getById(String uuid);

}
