package com.mall.api.ums;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.service.ums.IUmsMemberService;
import com.mall.vo.request.ums.AddUmsMemberRequest;
import com.mall.vo.request.ums.SearchUmsMemberRequest;
import com.mall.vo.response.common.Result;
import com.mall.vo.response.ums.UmsMemberInfoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    @ApiOperation("获取用户详情")
    public Result<UmsMemberInfoResponse> getUmsMemberDetail(@PathVariable("id") Long id){
        return umsMemberService.detail(id);
    }

    @GetMapping
    @ApiOperation("获取用户列表")
    public Result<IPage<UmsMemberInfoResponse>> getUmsMemberList(SearchUmsMemberRequest request){
        return umsMemberService.getUmsMemberList(request);
    }

    @PutMapping
    @ApiOperation("新增用户")
    public Result<String> addUser(@RequestBody @Valid AddUmsMemberRequest request, BindingResult result){
        if(result.hasErrors()){
            for(ObjectError error : result.getAllErrors()){
                return Result.<String>builder().error(500).msg(error.getDefaultMessage()).build();
            }
        }
        return umsMemberService.addUser(request);
    }

    @PutMapping("/batch")
    @ApiOperation("批量新增用户")
    public Result<String> addUser(@RequestBody @Valid List<AddUmsMemberRequest> request, BindingResult result){
        if(result.hasErrors()){
            for(ObjectError error : result.getAllErrors()){
                return Result.<String>builder().error(500).msg(error.getDefaultMessage()).build();
            }
        }
        return umsMemberService.addUserBatch(request);
    }

}
