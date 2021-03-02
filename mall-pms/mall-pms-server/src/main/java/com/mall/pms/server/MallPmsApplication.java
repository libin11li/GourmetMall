package com.mall.pms.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author li
 * description:
 * date: 2021/3/2
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = {"com.mall.pms.server.dao"})
public class MallPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallPmsApplication.class);
    }

}
