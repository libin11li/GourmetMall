package com.mall.vo.response.pms;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author li
 * description:
 * date: 2021-01-25
 */
@Data
public class PmsSkuSaleAttrResponse {

    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * skuId
     */
    @ApiModelProperty("skuId列表")
    private List<Long> skuId;

    /**
     * 销售属性名称
     */
    @ApiModelProperty("销售属性名称")
    private String attrName;

    /**
     * 销售属性值
     */
    @ApiModelProperty("销售属性值")
    private String attrValue;

}
