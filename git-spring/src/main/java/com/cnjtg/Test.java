package com.cnjtg;

import com.spring.CnjtgApplicationContext;

/**
 * @author cnjtg
 * @version 1.0
 * @className Test
 * @date 2021-04-29 16:24
 */
public class Test {

    public static void main(String[] args) {

        CnjtgApplicationContext applicationContext = new CnjtgApplicationContext(AppConfig.class);

        Object UserService = applicationContext.getBean("UserService");


    }
}
