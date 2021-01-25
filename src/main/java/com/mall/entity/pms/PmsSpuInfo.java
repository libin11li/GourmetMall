package com.mall.entity.pms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@TableName(value = "pms_spu_info")
public class PmsSpuInfo implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 商品名称
     */
    private String spuName;

    /**
     * 缩略图
     */
    private String pic;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 排序
     */
    private Integer priority;

    /**
     * 是否删除,0:未删除,1:已删除
     */
    private Integer deleteFlag;

}
