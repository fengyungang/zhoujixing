package com.zhoujixing.logic;


import com.zhoujixing.entity.GoodsModel;
import com.zhoujixing.entity.ShopsModel;
import com.zhoujixing.service.GoodsService;
import com.zhoujixing.service.ShopsService;
import com.zhoujixing.utils.DateUtils;
import com.zhoujixing.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 商铺逻辑层
 */
@Component
public class ShopsLogic {
    @Autowired
    private ShopsService shopsService;
    /**
     * 添加商铺
     * @param shopsModel
     * @return
     */
    public Result addShops(ShopsModel shopsModel){
        shopsModel.setShop_shops_create_time(new Date());
        int res = shopsService.add(shopsModel);
        return Result.generate(0,"add shops success",shopsModel);
    }

    /**
     * 根据id查询商铺
     * @param shop_shops_id
     * @return
     */
    public Result getById(Integer shop_shops_id){
        ShopsModel shopsModel = shopsService.getById(shop_shops_id);
        return Result.generate(0,"select shops success",shopsModel);
    }

    /**
     * 查询所有的商铺信息列表（可按条件模糊查询）
     * @param shop_shops_shopname
     * @param shop_shops_shopaddress
     * @param shop_shops_shoptel
     * @param shop_shops_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result selAll(String shop_shops_shopname, String shop_shops_shopaddress, String shop_shops_shoptel, String shop_shops_create_time,Integer pageIndex, Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("shop_shops_shopname",shop_shops_shopname);
        map.put("shop_shops_shopaddress",shop_shops_shopaddress);
        map.put("shop_shops_shoptel",shop_shops_shoptel);

        if (shop_shops_create_time!=null&&!"".equals(shop_shops_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("shop_shops_create_time", DateUtils.StD(shop_shops_create_time,"yyyy-MM-dd"));
        }
        return Result.generate(0,"select shops success",shopsService.selA(map,pageIndex,pageSize));
    }

    /**
     * 根据id修改商铺信息
     * @param shopsModel
     * @return
     */
    public Result updShops(ShopsModel shopsModel){
        int res = shopsService.update(shopsModel);
        if (res<0){
            return Result.generate(1,"update shops fail ",null);
        }
        return Result.generate(0,"update shops success",shopsModel);
    }


    /**
     *删除商铺
      * @return shop_shops_id
     */
    public Result delShops(Integer shop_shops_id){
       int i = shopsService.delById(shop_shops_id);
        if (i<0){
            return Result.generate(0,"delet shops fail",null);
        }else {
            return Result.generate(0,"delet shops success",null);
        }
    }


}