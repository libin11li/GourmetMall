package com.mall.api.ums;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.service.ums.IUmsMemberService;
import com.mall.vo.request.ums.AddUmsMemberRequest;
import com.mall.vo.request.ums.SearchUmsMemberRequest;
import com.mall.vo.response.common.Result;
import com.mall.vo.response.ums.UmsMemberInfoResponse;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PutMapping
    public Result<String> addUser(@RequestBody @Valid AddUmsMemberRequest request, BindingResult result){
        if(result.hasErrors()){
            for(ObjectError error : result.getAllErrors()){
                return Result.<String>builder().error(500).msg(error.getDefaultMessage()).build();
            }
        }
        return umsMemberService.addUser(request);

    }

}
