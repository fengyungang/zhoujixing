package com.zhoujixing.controller;

import com.zhoujixing.entity.Order;
import com.zhoujixing.entity.OrderDetails;
import com.zhoujixing.service.OrderDetailsService;
import com.zhoujixing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailsService orderDetailsService;

    @RequestMapping("/addorder")
    public Map<String,Object> addOrder(String buyerName,String buyerPhone,String buyerAddress,Double totalMoney,Integer orderStatus,Integer paymentStatus){
        Map<String,Object> modelMap = new HashMap<>();
        Order order = new Order();
        order.setBuyerName(buyerName);
        order.setBuyerPhone(buyerPhone);
        order.setBuyerAddress(buyerAddress);
        order.setTotalMoney(totalMoney);
        order.setOrderStatus(orderStatus);
        order.setPaymentStatus(paymentStatus);
        order.setCreateTime(new Date());
        modelMap.put("order",orderService.addOrder(order));
        return modelMap;
    }

    @RequestMapping("/getallorder")
    public Map<String,Object> getAllOrder(){
        Map<String,Object> modelMap = new HashMap<>();
        List<Order> list = orderService.getAllOrder();

        Order order = new Order();
        OrderDetails orderDetails = new OrderDetails();
        for(int i=0;i<list.size();i++){
            order = list.get(i);
            List<OrderDetails> list1 = orderDetailsService.getDetailsByBuyerId(order.getId());
            modelMap.put(order.getId().toString(),list1);
        }
        return modelMap;
    }

    @RequestMapping("/getbypaymentstatus")
    public Map<String,Object> getByPaymentStatus(Integer paymentStatus){
        Map<String,Object> modelMap = new HashMap<>();
        List<Order> list = orderService.getByPaymentStatus(paymentStatus);
        if (paymentStatus ==1){
            modelMap.put("已付款订单",list);
        }else {
            modelMap.put("未付款订单",list);
        }
        return modelMap;
    }

    @RequestMapping("/modifyorder")
    public Map<Object,String> modifyOrder(Integer id,String buyerName,String buyerPhone,String buyerAddress,Double totalMoney,Integer orderStatus,Integer paymentStatus){
        Map<Object,String> modelMap = new HashMap<>();
        Order order = orderService.getById(id);
        if (order != null){
            order.setBuyerName(buyerName);
            order.setBuyerPhone(buyerPhone);
            order.setBuyerAddress(buyerAddress);
            order.setTotalMoney(totalMoney);
            order.setOrderStatus(orderStatus);
            order.setPaymentStatus(paymentStatus);
            orderService.modifyOrder(order);
            modelMap.put(1,"订单修改成功！");
        }else {
            modelMap.put(0,"订单不存在！");
        }
        return modelMap;
    }

    @RequestMapping("/removeorder")
    public Map<Object,String> removeOrder(Integer id){
        Map<Object,String> modelMap = new HashMap<>();
        if (orderService.removeOrder(id)){
            modelMap.put(1,"删除成功！");
        }else {
            modelMap.put(0,"订单不存在！");
        }
        return modelMap;
    }



    @RequestMapping("/addorderdetails")
    public Map<String,Object> addOrderDetails(Integer buyerId,Integer dishId,Integer tableId,String dishName,Double price,Integer amount,String image){
        Map<String,Object> modelMap = new HashMap<>();
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setBuyerId(buyerId);
        orderDetails.setDishId(dishId);
        orderDetails.setTableId(tableId);
        orderDetails.setDishName(dishName);
        orderDetails.setPrice(price);
        orderDetails.setAmount(amount);
        orderDetails.setImage(image);
        orderDetails.setCreateTime(new Date());
        modelMap.put("orderDetails",orderDetailsService.addDetails(orderDetails));
        return modelMap;
    }

    @RequestMapping("/modifydetails")
    public Map<Object,String> modifyDetails(Integer id,Integer buyerId,Integer dishId,Integer tableId,String dishName,Double price,Integer amount,String image){
        Map<Object,String> modelMap = new HashMap<>();
        OrderDetails orderDetails = orderDetailsService.getById(id);
        if (orderDetails != null){
            orderDetails.setBuyerId(buyerId);
            orderDetails.setDishId(dishId);
            orderDetails.setTableId(tableId);
            orderDetails.setDishName(dishName);
            orderDetails.setPrice(price);
            orderDetails.setAmount(amount);
            orderDetails.setImage(image);
            orderDetailsService.modifyDetails(orderDetails);
            modelMap.put(1,"详情修改成功！");
        }else{
            modelMap.put(0,"该详情不存在！");
        }
        return modelMap;
    }

    @RequestMapping("/removedetails")
    public Map<Object,String> removeDetails(Integer id){
        Map<Object,String> modelMap = new HashMap<>();
        if (orderDetailsService.removeDetails(id)){
            modelMap.put(1,"删除成功！");
        }else {
            modelMap.put(0,"订单不存在！");
        }
        return modelMap;
    }

}
