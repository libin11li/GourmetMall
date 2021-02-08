package com.mall.dto.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.elasticsearch.search.sort.SortOrder;

/**
 * @author li
 * description:排序字段
 * date: 2021/2/8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SortField {

    /**
     * 字段名
     */
    private String fieldName;

    /**
     * 排序种类
     */
    private SortOrder sortOrder;
}
