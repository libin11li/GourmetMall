package com.mall.pms.client;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: li
 * description:
 * date: 2021/3/2
 */
public interface PmsClient {

    /**
     * 测试方法
     * @return 结果
     */
    @GetMapping("/base/test")
    String test();

}
