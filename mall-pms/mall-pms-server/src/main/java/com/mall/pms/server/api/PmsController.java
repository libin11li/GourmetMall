package com.mall.pms.server.api;

import com.mall.pms.server.service.IPmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author li
 * description:
 * date: 2021/3/2
 */
@RestController
@RequestMapping("/base")
@RequiredArgsConstructor
public class PmsController {

    private final IPmsService pmsService;

    @GetMapping("/test")
    public String test(){
        return pmsService.test();
    }

}
