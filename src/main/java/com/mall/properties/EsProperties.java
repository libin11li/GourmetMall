package com.mall.properties;

import lombok.Data;

/**
 * @author: li
 * description:
 * date: 2020/7/28
 */
@Data
public class EsProperties {

    /**
     * 地址
     */
    private String hostname;

    /**
     * 端口
     */
    private Integer port;

    /**
     * 所使用协议
     */
    private String scheme;

    /**
     * http连接超时时间
     */
    private int connectTimeOut = 1000;

    /**
     * socket连接超时时间
     */
    private int socketTimeOut = 30000;

    /**
     * 获取连接的超时时间
     */
    private int connectionRequestTimeOut = 500;

    /**
     * 最大连接数
     */
    private int maxConnectNum = 100;

    /**
     * 最大路由连接数
     */
    private int maxConnectPerRoute = 100;

}
