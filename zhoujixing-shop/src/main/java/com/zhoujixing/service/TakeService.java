package com.zhoujixing.service;

import com.zhoujixing.entity.ShopsModel;
import com.zhoujixing.entity.TakeModel;

import java.util.List;
import java.util.Map;

public interface TakeService {
    /**
     * 添加方法
     * @param takeModel
     * @return
     */
    int add(TakeModel takeModel);

    /**
     * 根据id查询一条信息
     * @param shop_take_id
     * @return
     */
    TakeModel getById(Integer shop_take_id);

    /**
     * 查询所有信息
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Map<String,Object> selA(Map<String, Object> map, Integer pageIndex, Integer pageSize);

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    List<TakeModel> selA(Map<String, Object> map);

    /**
     * 根据id修改某条信息
     * @param takeModel
     * @return
     */
    int update(TakeModel takeModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param shop_take_id
     * @return
     */
    int delById(Integer shop_take_id);

}
