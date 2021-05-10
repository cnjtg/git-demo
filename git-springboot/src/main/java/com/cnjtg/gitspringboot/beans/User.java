package com.cnjtg.gitspringboot.beans;

import lombok.Data;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-08 10:07
 */
@Data
public class User {
    private String username;
    private String password;
    private String uuid;
    private String address;
}
