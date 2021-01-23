package com.mall.mapper.ums;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.entity.ums.UmsMember;
import com.mall.vo.request.ums.AddUmsMemberRequest;
import com.mall.vo.request.ums.UpdateUmsMemberRequest;

import java.util.List;

/**
 * @author: li
 * description:
 * date: 2021/1/5
 */
public interface UmsMemberMapper extends BaseMapper<UmsMember> {

    /**
     * 批量插入
     * @param umsMembers 插入数据
     * @return 插入数量
     */
    int insertBatch(List<AddUmsMemberRequest> umsMembers);

    /**
     * 批量更新
     * @param umsMembers 更新数据
     * @return 更新数量
     */
    int updateBatch(List<UpdateUmsMemberRequest> umsMembers);

}
