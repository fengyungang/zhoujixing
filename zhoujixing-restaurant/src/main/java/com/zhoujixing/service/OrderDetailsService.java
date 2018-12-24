package com.zhoujixing.service;

import com.zhoujixing.entity.OrderDetails;

import java.util.List;

public interface OrderDetailsService {
    /**
     * 添加订单详情信息
     * @param orderDetails
     * @return
     */
    boolean addDetails(OrderDetails orderDetails);

    /**
     * 根据id查询订单详情
     * @param id
     * @return
     */
    OrderDetails getById(Integer id);

    /**
     * 根据买家id查询订单详情
     * @param buyerId
     * @return
     */
    List<OrderDetails> getDetailsByBuyerId(Integer buyerId);

    /**
     * 修改订单详情
     * @param orderDetails
     * @return
     */
    boolean modifyDetails(OrderDetails orderDetails);

    /**
     * 根据id删除订单详情
     * @param id
     * @return
     */
    boolean removeDetails(Integer id);
}
