package com.mall.member.server.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author li
 * description:
 * date: 2021/3/2
 */
@Data
@TableName(value = "ums_member")
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

    /**
     * 性别
     */
    private Integer sex;

}
