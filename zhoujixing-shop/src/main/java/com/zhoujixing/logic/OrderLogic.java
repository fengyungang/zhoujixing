package com.zhoujixing.logic;



import com.zhoujixing.entity.OrderModel;

import com.zhoujixing.service.OrderService;
import com.zhoujixing.utils.DateUtils;
import com.zhoujixing.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 订单逻辑层
 */
@Component
public class OrderLogic {
    @Autowired
    private OrderService orderService;
    /**
     * 添加订单
     * @param orderModel
     * @return
     */
    public Result addOrder(OrderModel orderModel){
        //还没有计算金额！！！
        orderModel.setShop_order_total_money(new BigDecimal("0.00"));
        orderModel.setShop_order_state("0");
        orderModel.setShop_order_create_time(new Date());
        int res = orderService.add(orderModel);
        return Result.generate(0,"add order success",orderModel);
    }

    /**
     * 根据id查询订单
     * @param shop_order_id
     * @return
     */
    public Result getById(Integer shop_order_id){
        OrderModel orderModel = orderService.getById(shop_order_id);
        return Result.generate(0,"select order success",orderModel);
    }

    /**
     * 查询订单表里所有的订单信息列表（可按条件模糊查询）
     * @param user_id
     * @param shop_goods_id
     * @param shop_order_goods_num
     * @param shop_order_total_money
     * @param shop_order_state
     * @param shop_order_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result selAll(Integer user_id, Integer shop_goods_id, Integer shop_order_goods_num, BigDecimal shop_order_total_money, String shop_order_state,String shop_order_create_time,Integer pageIndex, Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("user_id",user_id);
        map.put("shop_goods_id",shop_goods_id);
        map.put("shop_order_goods_num",shop_order_goods_num);
        map.put("shop_order_total_money",shop_order_total_money);
        map.put("shop_order_state",shop_order_state);

        if (shop_order_create_time!=null&&!"".equals(shop_order_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("shop_order_create_time", DateUtils.StD(shop_order_create_time,"yyyy-MM-dd"));
        }
        return Result.generate(0,"select order success",orderService.selA(map,pageIndex,pageSize));
    }

    /**
     * 根据id修改订单信息
     * @param orderModel
     * @return
     */
    public Result updOrder(OrderModel orderModel){
        int res = orderService.update(orderModel);
        if (res<0){
            return Result.generate(1,"update order fail ",null);
        }
        return Result.generate(0,"update order success",orderModel);
    }

    /**
     * 删除订单
      * @return shop_order_id
     */
    public Result delOrder(Integer shop_order_id){
        int i = orderService.delById(shop_order_id);
        if (i<0){
            return Result.generate(0,"delet order fail",null);
        }else {
            return Result.generate(0,"delet order success",null);
        }
    }


}