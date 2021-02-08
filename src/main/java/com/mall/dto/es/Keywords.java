package com.mall.dto.es;

import com.mall.enums.common.QueryTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author li
 * description: 搜索关键词封装类
 * date: 2021/2/8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Keywords{

    /**
     * 键
     */
    private String key;

    /**
     * 值
     */
    private Object value;

    /**
     * 类型
     */
    private QueryTypeEnum queryType;

}