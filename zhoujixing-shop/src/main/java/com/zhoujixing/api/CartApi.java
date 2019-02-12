package com.zhoujixing.api;

import com.zhoujixing.entity.CartModel;
import com.zhoujixing.logic.CartLogic;
import com.zhoujixing.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * 购物车api层
 */
@io.swagger.annotations.Api(value="cart接口", tags="cart接口")
@RestController
@RequestMapping("api/cart")
public class CartApi extends BaseApi {
    @Autowired
    private CartLogic cartLogic;

    /**
     * 在购物车表添加商品
     * @param token
     * @param cartModel
     * @return
     */
    @ApiOperation(value = "在购物车表添加商品",notes = "addCart接口的在购物车表添加商品信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "关联外键用户表的主键id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "shop_goods_id", value = "关联外键商品表的主键id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "shop_cart_num", value = "商品数量", required = true, dataType = "Integer", paramType = "form")
    })
    @PostMapping("/addCart")
    public Result addCart(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      CartModel cartModel)
    {
        return cartLogic.addCart(cartModel);
    }

    /**
     * 删除商品信息（逻辑删除）
     * @param token
     * @param shop_cart_id
     * @return
     */
    @ApiOperation(value = "删除商品信息",notes = "delCart接口的删除商品信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_cart_id", value = "购物车表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @PutMapping("/delCart")
    public Result delCart(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      Integer shop_cart_id)
    {
        return cartLogic.delCart(shop_cart_id);
    }

    /**
     *  查询购物车里所有的商品信息列表（可按条件模糊查询）
     * @param token
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
    @ApiOperation(value = "查询购物车里所有的商品信息列表（可按条件模糊查询）",notes = "selACart接口的查询购物车里所有的商品信息列表方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "关联外键用户表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_goods_id", value = "关联外键商品表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_cart_num", value = "商品数量", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_cart_state", value = "记录状态（0正常，1删除，2禁用）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_cart_create_time", value = "记录创建时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_cart_update_time", value = "记录更新时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selACart")
    public Result selACart(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer user_id, Integer shop_goods_id, Integer shop_cart_num,String shop_cart_state,String shop_cart_create_time, String shop_cart_update_time,Integer pageIndex,Integer pageSize)
    {

        return cartLogic.selAll(user_id, shop_goods_id, shop_cart_num, shop_cart_state, shop_cart_create_time, shop_cart_update_time, pageIndex, pageSize);
    }

    /**
     * 根据id修改购物车信息
     * @param token
     * @param cartModel
     * @return
     */
   @ApiOperation(value = "根据id修改购物车信息",notes = "updCart接口的根据id修改购物车信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_cart_id", value = "购物车表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @PutMapping("/updCart")
    public Result updCart(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              CartModel cartModel)
    {
        return cartLogic.updCart(cartModel);
    }

    /**
     * 根据id查询商品信息
     * @param token
     * @param shop_cart_id
     * @return
     */
    @ApiOperation(value = "根据id查询商品信息",notes = "selOCart接口的根据id查询商品信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_cart_id", value = "购物车表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selOCart")
    public Result selOCart(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer shop_cart_id)
    {
        return cartLogic.getById(shop_cart_id);
    }


}