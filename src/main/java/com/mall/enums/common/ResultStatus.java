package com.mall.enums.common;

import lombok.Getter;

/**
 * @author: li
 * description:统一返回业务code
 * date: 2021/1/6
 */
@Getter
public enum ResultStatus {

    //业务成功
    SUCCESS(0, "SUCCESS");

    /**
     * 业务code
     */
    private final Integer code;

    /**
     * 业务code对应的信息
     */
    private final String msg;

    ResultStatus(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
