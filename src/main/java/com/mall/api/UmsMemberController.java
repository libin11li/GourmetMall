package com.mall.api;

import com.mall.service.IUmsMemberService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author li
 * description:
 * date: 2021/1/5
 */
@RestController
@RequiredArgsConstructor
@Api(value = "UmsMemberController", tags = {"用户管理"})
public class UmsMemberController {

    private final IUmsMemberService umsMemberService;

    public

}
