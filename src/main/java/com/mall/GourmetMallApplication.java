package com.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author li
 * description:
 * date: 2021/1/5
 */
@SpringBootApplication
@MapperScan("com.mall.mapper")
public class GourmetMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(GourmetMallApplication.class, args);
    }

}
