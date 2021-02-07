package com.mall.properties;

import lombok.Data;

/**
 * @author li
 * description:
 * date: 2021/1/25
 */
@Data
public class SnowProperties {

    /**
     * 数据中心id
     */
    private Long dataCenterId;

    /**
     * 服务器ip列表
     */
    private String[] localIps;

    /**
     * 工作中心id
     */
    private Long workerId;

}
