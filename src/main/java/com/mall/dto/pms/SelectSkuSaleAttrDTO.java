package com.mall.dto.pms;

import lombok.Data;

/**
 * @author li
 * description:
 * date: 2021/1/25
 */
@Data
public class SelectSkuSaleAttrDTO {

    /**
     * 销售属性名称
     */
    private String attrName;

    /**
     * 销售属性值
     */
    private String attrValue;

    /**
     * skuId列表
     */
    private String skuIds;

}
