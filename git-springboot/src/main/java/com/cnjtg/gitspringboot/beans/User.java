package com.cnjtg.gitspringboot.beans;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-07 19:40
 */
@Component
@Data
@ConfigurationProperties(prefix = "user")
//@PropertySource("classpath:data/a.properties")
public class User {
    private String uuid;
    private String username;
    private Integer age;
    private Date birthday;
    private List<String> hobbies;
}
