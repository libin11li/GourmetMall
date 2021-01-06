package com.mall.vo.response.ums;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author li
 * description:
 * date: 2021/1/6
 */
@Data
public class UmsMemberInfoResponse {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("邮箱")
    private String email;

}
