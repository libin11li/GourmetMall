package com.mall.entity.ums;

import lombok.Data;

/**
 * @author li
 * description:
 * date: 2021/1/5
 */
@Data
public class UmsMember {

    /**
     * id
     */
    private Long id;

    /**
     * 昵称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

}
