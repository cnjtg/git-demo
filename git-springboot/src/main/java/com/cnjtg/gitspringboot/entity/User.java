package com.cnjtg.gitspringboot.entity;

import lombok.Data;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-11 16:45
 */
@Data
public class User {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * uuid
     */
    private String uuid;
    /**
     * 地址
     */
    private String address;
}
