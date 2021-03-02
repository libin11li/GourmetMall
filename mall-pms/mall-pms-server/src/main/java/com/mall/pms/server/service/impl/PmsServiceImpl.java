package com.mall.pms.server.service.impl;

import com.mall.pms.server.service.IPmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author li
 * description:
 * date: 2021/3/2
 */
@Service
@RequiredArgsConstructor
public class PmsServiceImpl implements IPmsService {


    @Override
    public String test() {
        return "pms ok";
    }
}
