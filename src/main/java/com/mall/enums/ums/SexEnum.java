package com.mall.enums.ums;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author: li
 * description:性别枚举
 * date: 2021/1/6
 */
public enum SexEnum {

    BOY(0, "男"),
    GIRL(1, "女");

    /**
     * 写入数据库的字段
     */
    @EnumValue
    private final Integer code;

    private final String desc;

    SexEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    /**
     * 返回参数转成json调用的方法
     * @return 性别枚举code
     */
    @JsonValue
    public Integer getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.getDesc();
    }

}
