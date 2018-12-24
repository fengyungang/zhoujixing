package com.zhoujixing.service.impl;

import com.zhoujixing.entity.OrderDetails;
import com.zhoujixing.mapper.OrderDetailsMapper;
import com.zhoujixing.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    @Override
    public boolean addDetails(OrderDetails orderDetails) {
        boolean result = false;
        if (orderDetailsMapper.insertDetails(orderDetails)>0){
            result = true;
        }
        return result;
    }

    @Override
    public OrderDetails getById(Integer id) {
        return orderDetailsMapper.selectById(id);
    }

    @Override
    public List<OrderDetails> getDetailsByBuyerId(Integer buyerId) {
        return orderDetailsMapper.selectByBuyerId(buyerId);
    }

    @Override
    public boolean modifyDetails(OrderDetails orderDetails) {
        boolean result = false;
        if (orderDetailsMapper.updateDetails(orderDetails)>0){
            result = true;
        }
        return result;
    }

    @Override
    public boolean removeDetails(Integer id) {
        boolean result = false;
        if (orderDetailsMapper.deleteDetails(id)>0){
            result = true;
        }
        return result;
    }
}
