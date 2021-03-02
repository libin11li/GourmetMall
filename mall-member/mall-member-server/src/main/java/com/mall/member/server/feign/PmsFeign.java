package com.mall.member.server.feign;

import com.mall.pms.client.PmsClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author li
 * description:
 * date: 2021/3/2
 */
@Component
@FeignClient("mall-pms")
public interface PmsFeign extends PmsClient {
}
