package com.mall.enums.ums;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author: li
 * description:性别枚举
 * date: 2021/1/6
 */
public enum SexEnum {

    /**
     * 男性
     */
    BOY(0),
    /**
     * 女性
     */
    GIRL(1);

    /**
     * 写入数据库的字段
     */
    @EnumValue
    private final Integer code;


    SexEnum(int code){
        this.code = code;
    }

    /**
     * 返回参数转成json调用的方法
     * @return 性别枚举code
     */
    @JsonValue
    public Integer getCode(){
        return this.code;
    }

}
