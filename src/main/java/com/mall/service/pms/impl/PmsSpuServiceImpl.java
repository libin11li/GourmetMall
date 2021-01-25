package com.mall.service.pms.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.mall.dto.pms.SelectSkuSaleAttrDTO;
import com.mall.entity.pms.PmsSkuInfo;
import com.mall.entity.pms.PmsSkuSaleAttr;
import com.mall.entity.pms.PmsSpuInfo;
import com.mall.exception.NormalException;
import com.mall.mapper.pms.PmsSkuInfoMapper;
import com.mall.mapper.pms.PmsSkuSaleAttrMapper;
import com.mall.mapper.pms.PmsSpuInfoMapper;
import com.mall.service.pms.IPmsSpuService;
import com.mall.vo.response.common.Result;
import com.mall.vo.response.pms.PmsSkuInfoResponse;
import com.mall.vo.response.pms.PmsSkuSaleAttrResponse;
import com.mall.vo.response.pms.PmsSkuSaleAttrValueResponse;
import com.mall.vo.response.pms.PmsSpuInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author li
 * description:
 * date: 2021-01-25
 */
@Service
@RequiredArgsConstructor
public class PmsSpuServiceImpl implements IPmsSpuService {

    private final PmsSpuInfoMapper spuInfoMapper;
    private final PmsSkuInfoMapper skuInfoMapper;
    private final PmsSkuSaleAttrMapper skuSaleAttrMapper;

    @Override
    public Result<PmsSpuInfoResponse> detail(Long id) {
        PmsSpuInfoResponse spuInfoResponse = new PmsSpuInfoResponse();
        //spu基本信息
        PmsSpuInfo spuInfo = spuInfoMapper.selectById(id);
        if(spuInfo == null){
            throw new NormalException("商品不存在");
        }
        BeanUtils.copyProperties(spuInfo, spuInfoResponse);
        //sku列表
        List<PmsSkuInfoResponse> skuInfoResponses = Lists.newArrayList();
        QueryWrapper<PmsSkuInfo> skuInfoWrapper = new QueryWrapper<>();
        skuInfoWrapper.lambda().eq(PmsSkuInfo :: getSpuId, id);
        skuInfoWrapper.orderByDesc("priority");
        List<PmsSkuInfo> pmsSkuInfos = skuInfoMapper.selectList(skuInfoWrapper);
        pmsSkuInfos.forEach(skuInfo -> {
            PmsSkuInfoResponse skuInfoResponse = new PmsSkuInfoResponse();
            BeanUtils.copyProperties(skuInfo, skuInfoResponse);
            skuInfoResponses.add(skuInfoResponse);
        });
        spuInfoResponse.setSkuInfos(skuInfoResponses);
        //sku-销售属性列表
        List<PmsSkuSaleAttrResponse> saleAttrs = Lists.newArrayList();
        List<SelectSkuSaleAttrDTO> pmsSkuSaleAttrs = skuSaleAttrMapper.selectGroupList(id);
        pmsSkuSaleAttrs.stream().collect(Collectors.groupingBy(SelectSkuSaleAttrDTO :: getAttrName)).forEach((attrName, attrValues) -> {
            PmsSkuSaleAttrResponse skuSaleAttrResponse = new PmsSkuSaleAttrResponse();
            skuSaleAttrResponse.setAttrName(attrName);
            List<PmsSkuSaleAttrValueResponse> attrValueResponses = Lists.newArrayList();
            attrValues.forEach(attrValue -> {
                PmsSkuSaleAttrValueResponse attrValueResponse = new PmsSkuSaleAttrValueResponse();
                attrValueResponse.setAttrValue(attrValue.getAttrValue());
                attrValueResponse.setSkuIds(attrValue.getSkuIds());
                attrValueResponses.add(attrValueResponse);
            });
            skuSaleAttrResponse.setAttrValues(attrValueResponses);
            saleAttrs.add(skuSaleAttrResponse);
        });
        spuInfoResponse.setSaleAttrs(saleAttrs);
        return Result.<PmsSpuInfoResponse>builder().success().data(spuInfoResponse).build();
    }

}
