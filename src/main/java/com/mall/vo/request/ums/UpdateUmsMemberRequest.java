package com.mall.vo.request.ums;

import com.mall.enums.ums.SexEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author li
 * description:
 * date: 2021/1/23
 */
@Data
public class UpdateUmsMemberRequest {

    /**
     * id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "主键id不能为空")
    private Long id;

    /**
     * 昵称
     */
    @NotBlank(message = "昵称不能为空")
    @ApiModelProperty("昵称")
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private SexEnum sex;

}
