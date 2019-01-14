package com.zhoujixing.service;


import com.zhoujixing.entity.CommentEntity;
import com.zhoujixing.entity.GoodEntity;

import java.util.List;
import java.util.Map;


public interface GoodService {
    /**
     * 添加方法
     * @param goodEntity
     * @return
     */
    int add(GoodEntity goodEntity);

    /**
     * 根据id查询一条信息
     * @param good_id
     * @return
     */
    GoodEntity getById(Integer good_id);

    /**
     * 查询所有信息（支持分页）
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Map<String,Object> selA(Map<String, Object> map, Integer pageIndex, Integer pageSize);

    /**
     * 根据id删除一条信息
     * @param good_id
     * @return
     */
    int delById(Integer good_id);

    /**
     * 获取点赞列表
     * @param map
     * @return
     */
    List<GoodEntity> getList(Map<String, Object> map);
}
