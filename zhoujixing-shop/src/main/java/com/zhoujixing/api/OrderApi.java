package com.zhoujixing.api;


import com.zhoujixing.entity.OrderModel;

import com.zhoujixing.logic.OrderLogic;
import com.zhoujixing.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 订单api层
 */
@io.swagger.annotations.Api(value="order接口", tags="order接口")
@RestController
@RequestMapping("api/order")
public class OrderApi extends BaseApi {
    @Autowired
    private OrderLogic orderLogic;

    /**
     * 添加订单
     * @param token
     * @param orderModel
     * @return
     */
    @ApiOperation(value = "添加订单",notes = "addOrder接口的添加订单信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "关联外键用户表的主键id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "shop_goods_id", value = "关联外键商品表的主键id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "shop_order_goods_num", value = "商品数量", required = true, dataType = "Integer", paramType = "form")
    })
    @PostMapping("/addOrder")
    public Result addOrder(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      OrderModel orderModel)
    {
        return orderLogic.addOrder(orderModel);
    }

    /**
     * 删除订单
     * @param token
     * @param shop_order_id
     * @return
     */
    @ApiOperation(value = "删除订单",notes = "delOrder接口的删除订单信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_order_id", value = "订单表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @DeleteMapping("/delOrder")
    public Result delOrder(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      Integer shop_order_id)
    {
        return orderLogic.delOrder(shop_order_id);
    }

    /**
     * 查询订单表里所有的订单信息列表（可按条件模糊查询）
     * @param token
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
    @ApiOperation(value = "查询订单表里所有的订单信息列表（可按条件模糊查询）",notes = "selAOrder接口的查询订单表里所有的订单信息列表方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "关联外键用户表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_goods_id", value = "关联外键商品表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_order_goods_num", value = "商品数量", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_order_total_money", value = "总金额", required = false, dataType = "bigdecimal", paramType = "query"),
            @ApiImplicitParam(name = "shop_order_state", value = "订单状态（0下单，1未支付，2支付成功，3已支付，4收货状态，5完成状态）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_order_create_time", value = "创建时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selAOrder")
    public Result selAOrder(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer user_id, Integer shop_goods_id, Integer shop_order_goods_num,BigDecimal shop_order_total_money,String shop_order_state, String shop_order_create_time,Integer pageIndex,Integer pageSize)
    {

        return orderLogic.selAll(user_id,shop_goods_id,shop_order_goods_num,shop_order_total_money,shop_order_state,shop_order_create_time,pageIndex,pageSize);
    }

    /**
     * 根据id修改订单信息
     * @param token
     * @param orderModel
     * @return
     */
   @ApiOperation(value = "根据id修改订单信息",notes = "updOrder接口的根据id修改订单信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_order_id", value = "订单表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @PutMapping("/updOrder")
    public Result updOrder(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              OrderModel orderModel)
    {
        return orderLogic.updOrder(orderModel);
    }

    /**
     * 根据id查询订单
     * @param token
     * @param shop_order_id
     * @return
     */
    @ApiOperation(value = "根据id查询订单",notes = "selOOrder接口的根据id查询订单信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_order_id", value = "订单表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selOOrder")
    public Result selOOrder(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer shop_order_id)
    {
        return orderLogic.getById(shop_order_id);
    }


}