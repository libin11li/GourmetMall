package com.mall.config;

import cn.hutool.core.lang.Snowflake;
import com.mall.properties.SnowProperties;
import com.mall.properties.ToolsProperties;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author li
 * description:
 * date: 2021/1/25
 */
@Configuration
public class SnowConfig {

    @Autowired
    private ToolsProperties toolsProperties;
//
//    @Bean
//    public Snowflake snowflake(){
//        SnowProperties snow = toolsProperties.getSnow();
//        long workerId;
//        try {
//            String ip = Inet4Address.getLocalHost().getHostAddress();
//            int position = Arrays.binarySearch(snow.getLocalIps(), ip);
//            if (position > -1) {
//                snow.setWorkerId(position + 1);
//            } else {
//                snow.setWorkerId(RandomUtils.nextLong(1, 31));
//            }
//        } catch (UnknownHostException e) {
//            worderId = RandomUtils.nextLong(1, 31);
//        }
//        return new Snowflake(snow.getWorkerId(), snow.getDataCenterId());
//    }

}
