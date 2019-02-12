package com.zhoujixing.logic;


import com.zhoujixing.entity.CategoryModel;
import com.zhoujixing.entity.GoodsModel;
import com.zhoujixing.service.CategoryService;
import com.zhoujixing.service.GoodsService;
import com.zhoujixing.utils.DateUtils;
import com.zhoujixing.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品逻辑层
 */
@Component
public class GoodsLogic {
    @Autowired
    private GoodsService goodsService;
    /**
     * 添加商品
     * @param goodsModel
     * @return
     */
    public Result addGoods(GoodsModel goodsModel){
        goodsModel.setShop_goods_state("0");
        goodsModel.setShop_goods_del("0");
        goodsModel.setShop_goods_create_time(new Date());
        int res = goodsService.add(goodsModel);
        return Result.generate(0,"add goods success",goodsModel);
    }

    /**
     * 根据id查询商品
     * @param shop_goods_id
     * @return
     */
    public Result getById(Integer shop_goods_id){
        GoodsModel goodsModel = goodsService.getById(shop_goods_id);
        return Result.generate(0,"select goods success",goodsModel);
    }

    /**
     * 查询分类表里所有的商品信息列表（可按条件模糊查询）
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
    public Result selAll(Integer shop_shops_id, Integer shop_category_id, String shop_goods_main_title, String shop_goods_sub_title, BigDecimal shop_goods_price, BigDecimal shop_goods_old_price, Integer shop_goods_buy, String shop_goods_img,String shop_goods_state,String shop_goods_del,String shop_goods_create_time,Integer pageIndex, Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("shop_shops_id",shop_shops_id);
        map.put("shop_category_id",shop_category_id);
        map.put("shop_goods_main_title",shop_goods_main_title);
        map.put("shop_goods_sub_title",shop_goods_sub_title);
        map.put("shop_goods_price",shop_goods_price);
        map.put("shop_goods_old_price",shop_goods_old_price);
        map.put("shop_goods_buy",shop_goods_buy);

        map.put("shop_goods_img",shop_goods_img);
        map.put("shop_goods_state",shop_goods_state);
        map.put("shop_goods_del",shop_goods_del);
        if (shop_goods_create_time!=null&&!"".equals(shop_goods_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("shop_goods_create_time", DateUtils.StD(shop_goods_create_time,"yyyy-MM-dd"));
        }
        return Result.generate(0,"select goods success",goodsService.selA(map,pageIndex,pageSize));
    }

    /**
     * 根据id修改商品信息
     * @param goodsModel
     * @return
     */
    public Result updGoods(GoodsModel goodsModel){
        int res = goodsService.update(goodsModel);
        if (res<0){
            return Result.generate(1,"update goods fail ",null);
        }
        return Result.generate(0,"update goods success",goodsModel);
    }

    /**
     * 根据id修改商品状态信息（上下架）
     * @param shop_goods_id
     * @return
     */
    public Result updGoodsState(Integer shop_goods_id){
        GoodsModel goodsModel=new GoodsModel();
        goodsModel.setShop_goods_id(shop_goods_id);
        goodsModel.setShop_goods_state("1");
        int res = goodsService.update(goodsModel);
        if (res<0){
            return Result.generate(1,"update goodsState fail ",null);
        }
        return Result.generate(0,"update goodsState success",goodsModel);
    }

    /**
     * 在逻辑上删除商品
      * @return shop_goods_id
     */
    public Result delGoods(Integer shop_goods_id){
        GoodsModel goodsModel =new GoodsModel();
        goodsModel.setShop_goods_id(shop_goods_id);
        goodsModel.setShop_goods_del("1");

        int i = goodsService.update(goodsModel);
        if (i<0){
            return Result.generate(0,"delet goods fail",null);
        }else {
            return Result.generate(0,"delet goods success",goodsModel);
        }
    }


}