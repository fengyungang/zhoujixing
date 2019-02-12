package com.zhoujixing.service;

import com.zhoujixing.entity.GoodDetailsModel;
import com.zhoujixing.entity.OrderModel;

import java.util.List;
import java.util.Map;

public interface OrderService {
    /**
     * 添加方法
     * @param orderModel
     * @return
     */
    int add(OrderModel orderModel);

    /**
     * 根据id查询一条信息
     * @param shop_order_id
     * @return
     */
    OrderModel getById(Integer shop_order_id);

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
    List<OrderModel> selA(Map<String, Object> map);

    /**
     * 根据id修改某条信息
     * @param orderModel
     * @return
     */
    int update(OrderModel orderModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param shop_order_id
     * @return
     */
    int delById(Integer shop_order_id);

}
