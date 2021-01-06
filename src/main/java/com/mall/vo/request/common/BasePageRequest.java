package com.mall.vo.request.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: li
 * description:
 * date: 2021/1/5
 */
@Data
public class BasePageRequest {

    @ApiModelProperty("页码")
    private Integer pageNum = 0;

    @ApiModelProperty("每页多少数据")
    private Integer pageSize = 10;

}
