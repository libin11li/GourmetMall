package com.mall.api.pms;

import com.mall.service.pms.IPmsSpuService;
import com.mall.vo.response.common.Result;
import com.mall.vo.response.pms.PmsSpuInfoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author li
 * description:
 * date: 2021-01-25
 */
@RestController
@RequiredArgsConstructor
@Api(value = "PmsController", tags = {"商品"})
@RequestMapping("/pms")
public class PmsSpuController {

    private final IPmsSpuService pmsService;

    @GetMapping("/{id}")
    @ApiOperation("获取商品详情")
    public Result<PmsSpuInfoResponse> detail(@PathVariable("id") Long id){
        return pmsService.detail(id);
    }

}
