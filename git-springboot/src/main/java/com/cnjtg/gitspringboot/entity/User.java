package com.cnjtg.gitspringboot.entity;

import lombok.Data;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-11 16:45
 */
@Data
public class User {
    private String username;
    private String password;
    private String uuid;
    private String address;
}
