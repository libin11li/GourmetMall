package com.mall.entity.pms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author li
 * description:
 * date: 2021-01-25
 */
@Data
@TableName(value = "pms_sku_sale_attr")
public class PmsSkuSaleAttr implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long spuId;

    /**
     * skuId
     */
    private Long skuId;

    /**
     * 销售属性名称
     */
    private String attrName;

    /**
     * 销售属性值
     */
    private String attrValue;

    public PmsSkuSaleAttr(Long skuId, String attrName, String attrValue) {
        this.skuId = skuId;
        this.attrName = attrName;
        this.attrValue = attrValue;
    }
}
