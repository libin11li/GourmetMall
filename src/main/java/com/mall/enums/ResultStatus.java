package com.mall.enums;

import lombok.Getter;

/**
 * @author: li
 * description:统一返回业务code
 * date: 2021/1/6
 */
@Getter
public enum ResultStatus {

    //业务成功
    SUCCESS("0", "SUCCESS");

    /**
     * 业务code
     */
    private String code;

    /**
     * 业务code对应的信息
     */
    private String msg;

    ResultStatus(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
