package com.cnjtg.gitspringboot.beans;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 结果
 *
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-08 9:57
 */
@Slf4j
@Data
public class Results {
    private int code;
    private String message;
    private Object data;

    private Results(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功
     *
     * @param message 消息
     * @param data    数据
     * @return {@link Results}
     */
    public static Results SUCCESS(String message, Object data) {
        return new Results(SUCCESS, message, data);
    }

    /**
     * 成功
     *
     * @param message 消息
     * @return {@link Results}
     */
    public static Results SUCCESS(String message) {
        return new Results(SUCCESS, message, null);
    }

    /**
     * 成功
     *
     * @return {@link Results}
     */
    public static Results SUCCESS() {
        return new Results(SUCCESS, "", null);
    }

    /**
     * 错误
     *
     * @param message 消息
     * @param data    数据
     * @return {@link Results}
     */
    public static Results ERROR(String message, Object data) {
        log.error(message,data);
        return new Results(ERROR, message, data);
    }

    /**
     * 错误
     *
     * @param message 消息
     * @return {@link Results}
     */
    public static Results ERROR(String message)  {
        log.error(message);
        return new Results(ERROR, message, null);
    }


    private final static int SUCCESS = 200;
    private final static int ERROR = -1;
}
