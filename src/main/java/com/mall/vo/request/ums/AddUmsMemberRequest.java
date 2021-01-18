package com.mall.vo.request.ums;

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

}
