package com.zhoujixing.service;


import com.zhoujixing.entity.CooperateEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface CooperateService {
    /**
     * 添加方法
     * @param cooperateEntity
     * @return
     */
    int add(CooperateEntity cooperateEntity);

    /**
     * 根据id查询一条信息
     * @param cooperate_id
     * @return
     */
    CooperateEntity getById(Integer cooperate_id);

    /**
     * 查询所有信息（支持分页）
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Map<String,Object> selA(Map<String,Object> map, Integer pageIndex, Integer pageSize);
    /**
     * 根据id修改某条信息
     * @param cooperateEntity
     * @return
     */
    int update(CooperateEntity cooperateEntity);

    /**
     * 根据id删除一条信息
     * @param cooperate_id
     * @return
     */
    int delById(Integer cooperate_id);
}
