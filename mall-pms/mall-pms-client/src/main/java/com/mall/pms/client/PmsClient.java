package com.mall.pms.client;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: li
 * description:
 * date: 2021/3/2
 */
public interface PmsClient {

    @GetMapping("/base/test")
    String test();

}
