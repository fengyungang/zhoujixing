package com.zhoujixing.service;

import com.zhoujixing.entity.GoodDetailsModel;
import com.zhoujixing.entity.GoodsModel;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    /**
     * 添加方法
     * @param goodsModel
     * @return
     */
    int add(GoodsModel goodsModel);

    /**
     * 根据id查询一条信息
     * @param shop_goods_id
     * @return
     */
    GoodsModel getById(Integer shop_goods_id);

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
    List<GoodsModel> selA(Map<String, Object> map);

    /**
     * 根据id修改某条信息
     * @param goodsModel
     * @return
     */
    int update(GoodsModel goodsModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param shop_goods_id
     * @return
     */
    int delById(Integer shop_goods_id);

}
