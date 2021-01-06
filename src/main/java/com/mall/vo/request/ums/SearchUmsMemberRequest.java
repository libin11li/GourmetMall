package com.mall.vo.request.ums;

import com.mall.vo.request.common.BasePageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author li
 * description:
 * date: 2021/1/6
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchUmsMemberRequest extends BasePageRequest {

    @ApiModelProperty("昵称")
    private String name;

}
