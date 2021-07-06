package com.cnjtg.gitspringboot.entity;

import lombok.Data;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-11 16:45
 */
@Data
public class Good {
    /**
     * id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 价格
     */
    private Double price;
    /**
     * 数
     */
    private Integer count;
}
