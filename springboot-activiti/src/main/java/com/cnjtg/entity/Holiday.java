package com.cnjtg.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-08 21:31
 */
@Data
public class Holiday implements Serializable {

    private Integer id;
    private String username;
    private Float num;
    private Date startDate;
    private String reason;
    private String type;
    private String remark;
}
