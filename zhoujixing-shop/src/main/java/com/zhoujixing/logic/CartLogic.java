package com.zhoujixing.logic;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhoujixing.entity.CartModel;

import com.zhoujixing.service.CartService;

import com.zhoujixing.utils.DateUtils;
import com.zhoujixing.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 购物车逻辑层
 */
@Component
public class CartLogic {
    @Autowired
    private CartService cartService;
    /**
     * 在购物车表添加商品
     * @param cartModel
     * @return
     */
    public Result addCart(CartModel cartModel){
        cartModel.setShop_cart_state("0");
        cartModel.setShop_cart_create_time(new Date());
        cartModel.setShop_cart_update_time(new Date());

        int res = cartService.add(cartModel);
        return Result.generate(0,"add cart success",cartModel);
    }

    /**
     * 根据id查询商品信息
     * @param shop_cart_id
     * @return
     */
    public Result getById(Integer shop_cart_id){
        CartModel cartModel = cartService.getById(shop_cart_id);
        return Result.generate(0,"select cart success",cartModel);
    }

    /**
     * 查询购物车里所有的商品信息列表（可按条件模糊查询）
     * @param user_id
     * @param shop_goods_id
     * @param shop_cart_num
     * @param shop_cart_state
     * @param shop_cart_create_time
     * @param shop_cart_update_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result selAll(Integer user_id, Integer shop_goods_id, Integer shop_cart_num,String shop_cart_state, String shop_cart_create_time,String shop_cart_update_time,Integer pageIndex,Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("user_id",user_id);
        map.put("shop_goods_id",shop_goods_id);
        map.put("shop_cart_num",shop_cart_num);
        map.put("shop_cart_state",shop_cart_state);
        if (shop_cart_create_time!=null&&!"".equals(shop_cart_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("shop_cart_create_time", DateUtils.StD(shop_cart_create_time,"yyyy-MM-dd"));
        }
        if (shop_cart_update_time!=null&&!"".equals(shop_cart_update_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("shop_cart_update_time", DateUtils.StD(shop_cart_update_time,"yyyy-MM-dd"));
        }
        return Result.generate(0,"select cart success",cartService.selA(map,pageIndex,pageSize));
    }

    /**
     * 根据id修改购物车信息
     * @param cartModel
     * @return
     */
    public Result updCart(CartModel cartModel){
        cartModel.setShop_cart_update_time(new Date());
        int res = cartService.update(cartModel);
        if (res<0){
            return Result.generate(1,"update cart fail ",null);
        }
        return Result.generate(0,"update cart success",cartModel);
    }

    /**
     * 在逻辑上删除商品信息
      * @return customer_id
     */
    public Result delCart(Integer shop_cart_id){
        CartModel cartModel = new CartModel();
        cartModel.setShop_cart_update_time(new Date());
        cartModel.setShop_cart_id(shop_cart_id);
        cartModel.setShop_cart_state("1");

        cartService.update(cartModel);
        return Result.generate(0,"delet cart success",cartModel);
    }


}