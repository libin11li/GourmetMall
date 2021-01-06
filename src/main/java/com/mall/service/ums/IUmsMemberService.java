package com.mall.service.ums;

import com.mall.vo.response.common.Result;
import com.mall.vo.response.ums.UmsMemberInfoResponse;

/**
 * @author li
 * description:
 * date: 2021/1/5
 */
public interface IUmsMemberService {

    /**
     * 获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    Result<UmsMemberInfoResponse> detail(Long id);

}
