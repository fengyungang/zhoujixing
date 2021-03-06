package com.zhoujixing.service;

import com.zhoujixing.entity.GoodsModel;
import com.zhoujixing.entity.ShopsModel;

import java.util.List;
import java.util.Map;

public interface ShopsService {
    /**
     * 添加方法
     * @param shopsModel
     * @return
     */
    int add(ShopsModel shopsModel);

    /**
     * 根据id查询一条信息
     * @param shop_shops_id
     * @return
     */
    ShopsModel getById(Integer shop_shops_id);

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
    List<ShopsModel> selA(Map<String, Object> map);

    /**
     * 根据id修改某条信息
     * @param shopsModel
     * @return
     */
    int update(ShopsModel shopsModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param shop_shops_id
     * @return
     */
    int delById(Integer shop_shops_id);

}
