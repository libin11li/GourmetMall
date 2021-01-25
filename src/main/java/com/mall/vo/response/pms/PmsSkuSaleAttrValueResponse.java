package com.mall.vo.response.pms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author li
 * description:
 * date: 2021/1/25
 */
@Data
public class PmsSkuSaleAttrValueResponse {

    /**
     * 销售属性值
     */
    @ApiModelProperty("销售属性值")
    private String attrValue;

    /**
     * skuId列表
     */
    @ApiModelProperty("skuId列表,使用,分割")
    private String skuIds;

}
