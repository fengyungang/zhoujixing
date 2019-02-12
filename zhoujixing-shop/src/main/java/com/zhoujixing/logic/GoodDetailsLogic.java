package com.zhoujixing.logic;


import com.zhoujixing.entity.CommentModel;
import com.zhoujixing.entity.GoodDetailsModel;
import com.zhoujixing.service.CommentService;
import com.zhoujixing.service.GoodDetailsService;
import com.zhoujixing.utils.DateUtils;
import com.zhoujixing.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品详情逻辑层
 */
@Component
public class GoodDetailsLogic {
    @Autowired
    private GoodDetailsService goodDetailsService;
    /**
     * 添加商品详情
     * @param goodDetailsModel
     * @return
     */
    public Result addGoodDetails(GoodDetailsModel goodDetailsModel){
        goodDetailsModel.setShop_good_details_create_time(new Date());

        int res = goodDetailsService.add(goodDetailsModel);
        return Result.generate(0,"add goodDetails success",goodDetailsModel);
    }

    /**
     * 根据id查询商品的详情
     * @param shop_good_details_id
     * @return
     */
    public Result getById(Integer shop_good_details_id){
        GoodDetailsModel goodDetailsModel = goodDetailsService.getById(shop_good_details_id);
        return Result.generate(0,"select goodDetails success",goodDetailsModel);
    }

    /**
     * 查询所有的商品详情信息列表（可按条件模糊查询）
     * @param shop_goods_id
     * @param shop_good_details_detail
     * @param shop_good_details_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result selAll(Integer shop_goods_id, String shop_good_details_detail,String shop_good_details_create_time,Integer pageIndex,Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();
        map.put("shop_goods_id",shop_goods_id);
        map.put("shop_good_details_detail",shop_good_details_detail);

        if (shop_good_details_create_time!=null&&!"".equals(shop_good_details_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("shop_good_details_create_time", DateUtils.StD(shop_good_details_create_time,"yyyy-MM-dd"));
        }
        return Result.generate(0,"select goodDetails success",goodDetailsService.selA(map,pageIndex,pageSize));
    }

    /**
     * 根据id修改商品详情信息
     * @param goodDetailsModel
     * @return
     */
    public Result updGoodDetails(GoodDetailsModel goodDetailsModel){
        int res = goodDetailsService.update(goodDetailsModel);
        if (res<0){
            return Result.generate(1,"update goodDetails fail ",null);
        }
        return Result.generate(0,"update goodDetails success",goodDetailsModel);
    }

    /**
     * 删除商品详情
      * @return customer_id
     */
    public Result delGoodDetails(Integer shop_good_details_id){

        int res = goodDetailsService.delById(shop_good_details_id);
        if (res<0){
            return Result.generate(0,"delet goodDetails fail",null);
        }else {
            return Result.generate(0,"delet goodDetails success",null);
        }
       
    }


}