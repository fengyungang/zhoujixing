package com.zhoujixing.api;


import com.zhoujixing.entity.GoodsModel;

import com.zhoujixing.logic.GoodsLogic;
import com.zhoujixing.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 商品表api层
 */
@io.swagger.annotations.Api(value="goods接口", tags="goods接口")
@RestController
@RequestMapping("api/goods")
public class GoodsApi extends BaseApi {
    @Autowired
    private GoodsLogic goodsLogic;

    /**
     * 添加商品
     * @param token
     * @param goodsModel
     * @return
     */
    @ApiOperation(value = "添加商品",notes = "addGoods接口的添加商品信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_shops_id", value = "关联外键商铺表的主键id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "shop_category_id", value = "关联外键分类表的主键id", required = false, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "shop_goods_main_title", value = "商品主标题", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "shop_goods_sub_title", value = "商品副标题", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "shop_goods_price", value = "商品价格", required = true, dataType = "bigdecimal", paramType = "form"),
            @ApiImplicitParam(name = "shop_goods_old_price", value = "原价", required = true, dataType = "bigdecimal", paramType = "form"),
            @ApiImplicitParam(name = "shop_goods_buy", value = "购买人数", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "shop_goods_img", value = "商品图", required = true, dataType = "String", paramType = "form")
    })
    @PostMapping("/addGoods")
    public Result addGoods(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      GoodsModel goodsModel)
    {
        return goodsLogic.addGoods(goodsModel);
    }

    /**
     * 删除商品（逻辑删除）
     * @param token
     * @param shop_goods_id
     * @return
     */
    @ApiOperation(value = "删除商品",notes = "delGoods接口的删除商品信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_goods_id", value = "商品表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @PutMapping("/delGoods")
    public Result delGoods(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      Integer shop_goods_id)
    {
        return goodsLogic.delGoods(shop_goods_id);
    }

    /**
     * 查询分类表里所有的商品信息列表（可按条件模糊查询）
     * @param token
     * @param shop_shops_id
     * @param shop_category_id
     * @param shop_goods_main_title
     * @param shop_goods_sub_title
     * @param shop_goods_price
     * @param shop_goods_old_price
     * @param shop_goods_buy
     * @param shop_goods_img
     * @param shop_goods_state
     * @param shop_goods_del
     * @param shop_goods_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询分类表里所有的商品信息列表（可按条件模糊查询）",notes = "selAGoods接口的查询分类表里所有的商品信息列表方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_shops_id", value = "关联外键商铺表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_category_id", value = "关联外键分类表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_goods_main_title", value = "商品主标题", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_goods_sub_title", value = "商品副标题", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_goods_price", value = "商品价格", required = false, dataType = "bigdecimal", paramType = "query"),
            @ApiImplicitParam(name = "shop_goods_old_price", value = "原价", required = false, dataType = "bigdecimal", paramType = "query"),
            @ApiImplicitParam(name = "shop_goods_buy", value = "购买人数", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_goods_img", value = "商品图", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_goods_state", value = "商品状态（0下架，1上架）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_goods_del", value = "商品删除状态（0未删除，1已删除）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_goods_create_time", value = "创建时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selAGoods")
    public Result selAGoods(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                            Integer shop_shops_id, Integer shop_category_id, String shop_goods_main_title, String shop_goods_sub_title, BigDecimal shop_goods_price, BigDecimal shop_goods_old_price, Integer shop_goods_buy, String shop_goods_img, String shop_goods_state,String shop_goods_del,String shop_goods_create_time,Integer pageIndex, Integer pageSize)
    {

        return goodsLogic.selAll(shop_shops_id,shop_category_id,shop_goods_main_title,shop_goods_sub_title,shop_goods_price,shop_goods_old_price,shop_goods_buy,shop_goods_img,shop_goods_state,shop_goods_del,shop_goods_create_time,pageIndex,pageSize);
    }

    /**
     *  根据id修改商品信息
     * @param token
     * @param goodsModel
     * @return
     */
   @ApiOperation(value = " 根据id修改商品信息",notes = "updGoods接口的根据id修改商品信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_goods_id", value = "商品表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @PutMapping("/updGoods")
    public Result updGoods(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              GoodsModel goodsModel)
    {
        return goodsLogic.updGoods(goodsModel);
    }

    /**
     *  根据id修改商品状态信息（上下架）
     * @param token
     * @param shop_goods_id
     * @return
     */
    @ApiOperation(value = " 根据id修改商品状态信息（上下架）",notes = "updGoodsState接口的根据id修改商品状态信息（上下架）方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_goods_id", value = "商品表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @PutMapping("/updGoodsState")
    public Result updGoodsState(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                           Integer shop_goods_id)
    {
        return goodsLogic.updGoodsState(shop_goods_id);
    }


    /**
     * 根据id查询商品
     * @param token
     * @param shop_goods_id
     * @return
     */
    @ApiOperation(value = "根据id查询商品",notes = "selOGoods接口的根据id查询商品信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_goods_id", value = "商品表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selOGoods")
    public Result selOGoods(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer shop_goods_id)
    {
        return goodsLogic.getById(shop_goods_id);
    }


}