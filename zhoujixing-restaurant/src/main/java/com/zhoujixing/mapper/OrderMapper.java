package com.zhoujixing.mapper;


import com.zhoujixing.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    /**
     * 插入订单信息
     * @param order
     * @return
     */
    int insertOrder(Order order);

    /**
     * 查询订单信息
     * @return
     */
    List<Order> selectAllOrder();

    /**
     * 根据支付状态查询订单信息
     * @param paymentStatus
     * @return
     */
    List<Order> selectByPaymentStatus(Integer paymentStatus);

    /**
     * 根据id查询订单信息
     * @param id
     * @return
     */
    Order selectById(Integer id);

    /**
     * 修改订单信息
     * @param order
     * @return
     */
    int updateOrder(Order order);

    /**
     * 根据id删除订单信息
     * @param id
     * @return
     */
    int deleteOrder(Integer id);
}
