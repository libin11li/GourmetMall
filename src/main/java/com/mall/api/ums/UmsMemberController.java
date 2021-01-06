package com.mall.api.ums;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.service.ums.IUmsMemberService;
import com.mall.vo.request.ums.SearchUmsMemberRequest;
import com.mall.vo.response.common.Result;
import com.mall.vo.response.ums.UmsMemberInfoResponse;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author li
 * description:
 * date: 2021/1/5
 */
@RestController
@RequiredArgsConstructor
@Api(value = "UmsMemberController", tags = {"用户管理"})
@RequestMapping("/ums")
public class UmsMemberController {

    private final IUmsMemberService umsMemberService;

    @GetMapping
    public Result<UmsMemberInfoResponse> getUmsMember(SearchUmsMemberRequest request){
        return Result.<UmsMemberInfoResponse>builder().success().data(new UmsMemberInfoResponse()).build();
    }

}
