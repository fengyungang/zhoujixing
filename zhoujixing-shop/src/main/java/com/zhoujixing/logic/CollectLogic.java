package com.zhoujixing.logic;


import com.zhoujixing.entity.CartModel;
import com.zhoujixing.entity.CollectModel;
import com.zhoujixing.service.CartService;
import com.zhoujixing.service.CollectService;
import com.zhoujixing.utils.DateUtils;
import com.zhoujixing.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 收藏表逻辑层
 */
@Component
public class CollectLogic {
    @Autowired
    private CollectService collectService;
    /**
     * 添加商品到收藏表里
     * @param collectModel
     * @return
     */
    public Result addCollect(CollectModel collectModel){
        collectModel.setShop_collect_create_time(new Date());

        int res = collectService.add(collectModel);
        return Result.generate(0,"add collect success",collectModel);
    }

    /**
     * 根据id查询收藏信息
     * @param shop_collect_id
     * @return
     */
    public Result getById(Integer shop_collect_id){
        CollectModel collectModel = collectService.getById(shop_collect_id);
        return Result.generate(0,"select collect success",collectModel);
    }

    /**
     * 查询收藏表里所有的信息列表（可按条件模糊查询）
     * @param user_id
     * @param shop_goods_id
     * @param shop_collect_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result selAll(Integer user_id, Integer shop_goods_id, String shop_collect_create_time,Integer pageIndex,Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("user_id",user_id);
        map.put("shop_goods_id",shop_goods_id);

        if (shop_collect_create_time!=null&&!"".equals(shop_collect_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("shop_collect_create_time", DateUtils.StD(shop_collect_create_time,"yyyy-MM-dd"));
        }
        return Result.generate(0,"select collect success",collectService.selA(map,pageIndex,pageSize));
    }

    /**
     * 根据id修改收藏表信息
     * @param collectModel
     * @return
     */
    public Result updCollect(CollectModel collectModel){

        int res = collectService.update(collectModel);
        if (res<0){
            return Result.generate(1,"update collect fail ",null);
        }
        return Result.generate(0,"update collect success",collectModel);
    }

    /**
     * 删除收藏信息
      * @return customer_id
     */
    public Result delCollect(Integer shop_collect_id){
      CollectModel collectModel=new CollectModel();
      collectModel.setShop_collect_id(shop_collect_id);

        int res = collectService.delById(shop_collect_id);
        if (res<0){
            return Result.generate(0,"delet collect fail",null);
        }else {
            return Result.generate(0,"delet collect success",null);
        }
    }


}