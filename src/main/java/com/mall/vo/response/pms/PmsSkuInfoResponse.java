package com.mall.vo.response.pms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author li
 * description:
 * date: 2021-01-25
 */
@Data
public class PmsSkuInfoResponse {

    /**
     * id
     */
    @ApiModelProperty("SkuId")
    private Long id;

    /**
     * 市场价
     */
    @ApiModelProperty("市场价")
    private BigDecimal marketPrice;

    /**
     * 价格
     */
    @ApiModelProperty("价格")
    private BigDecimal price;


}
