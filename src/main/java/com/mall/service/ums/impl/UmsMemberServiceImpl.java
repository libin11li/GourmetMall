package com.mall.service.ums.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mall.entity.ums.UmsMember;
import com.mall.mapper.ums.UmsMemberMapper;
import com.mall.service.ums.IUmsMemberService;
import com.mall.vo.request.ums.SearchUmsMemberRequest;
import com.mall.vo.response.common.Result;
import com.mall.vo.response.ums.UmsMemberInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author li
 * description:
 * date: 2021/1/5
 */
@Service
@RequiredArgsConstructor
public class UmsMemberServiceImpl implements IUmsMemberService {

    private final UmsMemberMapper umsMemberMapper;

    @Override
    public Result<UmsMemberInfoResponse> detail(Long id) {
        UmsMember umsMember = umsMemberMapper.selectById(id);
        UmsMemberInfoResponse umsMemberInfoResponse = new UmsMemberInfoResponse();
        BeanUtils.copyProperties(umsMember, umsMemberInfoResponse);
        return Result.<UmsMemberInfoResponse>builder().success().data(umsMemberInfoResponse).build();
    }

    @Override
    public Result<UmsMemberInfoResponse> getUmsMemberList(SearchUmsMemberRequest request) {
        return null;
    }
}
