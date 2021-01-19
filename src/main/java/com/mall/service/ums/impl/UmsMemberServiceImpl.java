package com.mall.service.ums.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.mall.entity.ums.UmsMember;
import com.mall.mapper.ums.UmsMemberMapper;
import com.mall.service.ums.IUmsMemberService;
import com.mall.vo.request.ums.AddUmsMemberRequest;
import com.mall.vo.request.ums.SearchUmsMemberRequest;
import com.mall.vo.response.common.Result;
import com.mall.vo.response.ums.UmsMemberInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Result<IPage<UmsMemberInfoResponse>> getUmsMemberList(SearchUmsMemberRequest request) {
        Page<UmsMember> page = new Page<>(request.getPageNum(), request.getPageSize());
        Page<UmsMember> memberPage = umsMemberMapper.selectPage(page, null);
        List<UmsMemberInfoResponse> umsMemberInfoResponses = Lists.newArrayList();
        List<UmsMember> records = memberPage.getRecords();
        for(UmsMember umsMember : records){
            UmsMemberInfoResponse umsMemberInfoResponse = new UmsMemberInfoResponse();
            BeanUtils.copyProperties(umsMember, umsMemberInfoResponse);
            umsMemberInfoResponses.add(umsMemberInfoResponse);
        }
        Page<UmsMemberInfoResponse> resultData = new Page<>();
        BeanUtils.copyProperties(memberPage, resultData);
        resultData.setRecords(umsMemberInfoResponses);
        return Result.<IPage<UmsMemberInfoResponse>>builder().success().data(resultData).build();
    }

    @Override
    public Result<String> addUser(AddUmsMemberRequest request) {
        UmsMember umsMember = new UmsMember();
        BeanUtils.copyProperties(request, umsMember);
        umsMemberMapper.insert(umsMember);
        return Result.<String>builder().success().build();
    }

    @Override
    public Result<String> addUserBatch(List<AddUmsMemberRequest> request) {
        umsMemberMapper.insertBatch(request);
        return Result.<String>builder().success().build();
    }

}
