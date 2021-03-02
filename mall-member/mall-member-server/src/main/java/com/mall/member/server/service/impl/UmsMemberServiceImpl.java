package com.mall.member.server.service.impl;

import com.mall.member.server.feign.PmsFeign;
import com.mall.member.server.service.IUmsMemberService;
import com.mall.member.server.dao.UmsMemberMapper;
import com.mall.pms.client.PmsClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author li
 * description:
 * date: 2021/3/2
 */
@Service
@RequiredArgsConstructor
public class UmsMemberServiceImpl implements IUmsMemberService {

    private final UmsMemberMapper umsMemberMapper;
    private final PmsFeign pmsFeign;

    @Override
    public String test() {
        return umsMemberMapper.selectById(1).toString() + pmsFeign.test();
    }
}
