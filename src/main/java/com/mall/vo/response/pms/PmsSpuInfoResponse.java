package com.mall.vo.response.pms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author li
 * description:
 * date: 2021-01-25
 */
@Data
public class PmsSpuInfoResponse {

    /**
     * id
     */
    @ApiModelProperty("spuId")
    private Long id;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String spuName;

    /**
     * 缩略图
     */
    @ApiModelProperty("缩略图")
    private String pic;

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
