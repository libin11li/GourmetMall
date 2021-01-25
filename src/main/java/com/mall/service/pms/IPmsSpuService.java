package com.mall.service.pms;

import com.mall.vo.response.common.Result;
import com.mall.vo.response.pms.PmsSpuInfoResponse;

/**
 * @author li
 * description:
 * date: 2021-01-25
 */
public interface IPmsSpuService {

    /**
     * 获取商品详情
     * @param id spuId
     * @return 商品详情
     */
    Result<PmsSpuInfoResponse> detail(Long id);

}
