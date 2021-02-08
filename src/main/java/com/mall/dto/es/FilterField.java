package com.mall.dto.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author li
 * description:范围匹配字段
 * date: 2021/2/8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterField {

    /**
     * 键
     */
    private String key;

    /**
     * 起始值
     */
    private Object lowValue;

    /**
     * 结束值
     */
    private Object highValue;

}
