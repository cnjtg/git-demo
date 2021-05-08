package com.cnjtg.gitspringboot.beans;

import lombok.extern.slf4j.Slf4j;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-08 9:57
 */
@Slf4j
public class Results {
    private int code;
    private String message;
    private Object data;

    private Results(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Results SUCCESS(String message, Object data) {
        return new Results(SUCCESS, message, data);
    }

    public static Results SUCCESS(String message) {
        return new Results(SUCCESS, message, null);
    }

    public static Results ERROR(String message, Object data) {
        log.error(message,data);
        return new Results(ERROR, message, data);
    }

    private final static int SUCCESS = 1;
    private final static int ERROR = -1;
}
