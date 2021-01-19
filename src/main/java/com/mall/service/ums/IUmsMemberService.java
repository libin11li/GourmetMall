package com.mall.service.ums;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mall.vo.request.ums.AddUmsMemberRequest;
import com.mall.vo.request.ums.SearchUmsMemberRequest;
import com.mall.vo.response.common.Result;
import com.mall.vo.response.ums.UmsMemberInfoResponse;

import java.util.List;

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

    /**
     * 搜索用户列表
     * @param request 搜索条件
     * @return 用户列表
     */
    Result<IPage<UmsMemberInfoResponse>> getUmsMemberList(SearchUmsMemberRequest request);

    /**
     * 新增用户
     * @param request 用户信息
     * @return 新增结果
     */
    Result<String> addUser(AddUmsMemberRequest request);

    /**
     * 批量新增用户
     * @param request 用户信息
     * @return 新增结果
     */
    Result<String> addUserBatch(List<AddUmsMemberRequest> request);

}
