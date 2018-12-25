package com.zhoujixing.service.impl;

import com.zhoujixing.entity.Order;
import com.zhoujixing.mapper.OrderMapper;
import com.zhoujixing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public boolean addOrder(Order order) {
        boolean result = false;
        if (orderMapper.insertOrder(order)>0){
            result = true;
        }
        return result;
    }

    @Override
    public List<Order> getAllOrder() {
        return orderMapper.selectAllOrder();
    }

    @Override
    public List<Order> getByPaymentStatus(Integer paymentStatus) {
        return orderMapper.selectByPaymentStatus(paymentStatus);
    }

    @Override
    public Order getById(Integer id) {
        return orderMapper.selectById(id);
    }

    @Override
    public boolean modifyOrder(Order order) {
        boolean result = false;
        if (orderMapper.updateOrder(order)>0){
            result = true;
        }
        return result;
    }

    @Override
    public boolean removeOrder(Integer id) {
        boolean reslut = false;
        if (orderMapper.deleteOrder(id)>0){
            reslut = true;
        }
        return reslut;
    }
}
