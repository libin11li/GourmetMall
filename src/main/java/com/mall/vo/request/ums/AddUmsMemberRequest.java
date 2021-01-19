package com.mall.vo.request.ums;

import com.mall.enums.ums.SexEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author li
 * description:
 * date: 2021/1/5
 */
@Data
public class AddUmsMemberRequest {

    /**
     * 昵称
     */
    @NotBlank(message = "昵称不能为空")
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
    private SexEnum sex;

}
