package com.mall.dto.es;

import com.mall.vo.request.common.BasePageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

/**
 * @author: li
 * description:
 * date: 2020/7/27
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchDataFromEs extends BasePageRequest {

    /**
     * 搜索关键词
     */
    private List<Keywords> keyword;

    /**
     * 排序字段
     */
    private List<SortField> sortFields;

    /**
     * 范围匹配字段
     */
    private List<FilterField> filterFields;

}
