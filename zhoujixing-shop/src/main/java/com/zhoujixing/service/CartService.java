package com.zhoujixing.service;

import com.zhoujixing.entity.CartModel;



import java.util.List;
import java.util.Map;

public interface CartService {
    /**
     * 添加方法
     * @param cartModel
     * @return
     */
    int add(CartModel cartModel);

    /**
     * 根据id查询一条信息
     * @param shop_cart_id
     * @return
     */
    CartModel getById(Integer shop_cart_id);

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
    List<CartModel> selA(Map<String, Object> map);

    /**
     * 根据id修改某条信息
     * @param cartModel
     * @return
     */
    int update(CartModel cartModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param shop_cart_id
     * @return
     */
    int delById(Integer shop_cart_id);

}
