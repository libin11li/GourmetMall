package com.mall.mapper.pms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.dto.pms.SelectSkuSaleAttrDTO;
import com.mall.entity.pms.PmsSkuSaleAttr;
import com.mall.entity.ums.UmsMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: li
 * description:
 * date: 2021/1/5
 */
public interface PmsSkuSaleAttrMapper extends BaseMapper<PmsSkuSaleAttr> {

    /**
     * 查询销售属性列表(分组后)
     * @param spuId spuId
     * @return 销售属性列表
     */
    List<SelectSkuSaleAttrDTO> selectGroupList(@Param("spuId") Long spuId);

}
