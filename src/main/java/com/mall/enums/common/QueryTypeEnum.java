package com.mall.enums.common;

/**
 * @author: li
 * description:ES搜索类型枚举
 * date: 2021/2/8
 */
public enum QueryTypeEnum {

    /**
     * 相同
     */
    MUST,
    /**
     * 不相同
     */
    MUST_NOT,
    /**
     * 模糊搜索
     */
    SHOULD;

}
