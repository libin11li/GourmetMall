package com.mall.api.ums;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.service.ums.IUmsMemberService;
import com.mall.vo.request.ums.SearchUmsMemberRequest;
import com.mall.vo.response.common.Result;
import com.mall.vo.response.ums.UmsMemberInfoResponse;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public Result<UmsMemberInfoResponse> getUmsMemberDetail(@PathVariable("id") Long id){
        return umsMemberService.detail(id);
    }

    @GetMapping
    public Result<IPage<UmsMemberInfoResponse>> getUmsMemberList(SearchUmsMemberRequest request){
        return umsMemberService.getUmsMemberList(request);
    }

}
