package com.mall.entity.ums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mall.enums.ums.SexEnum;
import lombok.Data;

/**
 * @author li
 * description:
 * date: 2021/1/5
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
    @EnumValue
    private SexEnum sex;

}
