package com.zhoujixing.service;

import com.zhoujixing.entity.Order;

import java.util.List;

public interface OrderService {

    /**
     * 添加订单信息
     * @param order
     * @return
     */
    boolean addOrder(Order order);

    /**
     * 获取所有订单信息
     * @return
     */
    List<Order> getAllOrder();

    /**
     * 根据支付状态查询订单信息
     * @param paymentStatus
     * @return
     */
    List<Order> getByPaymentStatus(Integer paymentStatus);

    /**
     * 根据id查询订单信息
     * @param id
     * @return
     */
    Order getById(Integer id);

    /**
     * 修改订单信息
     * @param order
     * @return
     */
    boolean modifyOrder(Order order);

    /**
     * 根据id删除订单信息
     * @param id
     * @return
     */
    boolean removeOrder(Integer id);
}
