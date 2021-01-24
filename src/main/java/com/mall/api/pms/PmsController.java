package com.mall.api.pms;

import com.mall.service.pms.IPmsService;
import com.mall.vo.response.common.Result;
import com.mall.vo.response.pms.PmsSpuInfoResponse;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
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
public class PmsController {

    private final IPmsService pmsService;

}
