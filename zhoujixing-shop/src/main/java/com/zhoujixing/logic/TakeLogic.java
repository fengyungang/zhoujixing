package com.zhoujixing.logic;


import com.zhoujixing.entity.GoodsModel;
import com.zhoujixing.entity.TakeModel;
import com.zhoujixing.service.GoodsService;
import com.zhoujixing.service.TakeService;
import com.zhoujixing.utils.DateUtils;
import com.zhoujixing.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 收货地址表逻辑层
 */
@Component
public class TakeLogic {
    @Autowired
    private TakeService takeService;
    /**
     * 添加收货地址
     * @param takeModel
     * @return
     */
    public Result addTake(TakeModel takeModel){
        takeModel.setShop_take_create_time(new Date());
        int res = takeService.add(takeModel);
        return Result.generate(0,"add take success",takeModel);
    }

    /**
     * 根据id查询收货地址信息
     * @param shop_take_id
     * @return
     */
    public Result getById(Integer shop_take_id){
        TakeModel takeModel = takeService.getById(shop_take_id);
        return Result.generate(0,"select take success",takeModel);
    }

    /**
     * 查询所有的收货地址信息列表（可按条件模糊查询）
     * @param user_id
     * @param shop_take_consignee
     * @param shop_take_province
     * @param shop_take_city
     * @param shop_take_county
     * @param shop_take_street
     * @param shop_take_tel
     * @param shop_take_postcode
     * @param shop_take_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result selAll(Integer user_id, String shop_take_consignee, String shop_take_province, String shop_take_city, String shop_take_county, String shop_take_street, String shop_take_tel, String shop_take_postcode,String shop_take_create_time,Integer pageIndex, Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("user_id",user_id);
        map.put("shop_take_consignee",shop_take_consignee);
        map.put("shop_take_province",shop_take_province);
        map.put("shop_take_city",shop_take_city);
        map.put("shop_take_county",shop_take_county);
        map.put("shop_take_street",shop_take_street);
        map.put("shop_take_tel",shop_take_tel);

        map.put("shop_take_postcode",shop_take_postcode);

        if (shop_take_create_time!=null&&!"".equals(shop_take_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("shop_take_create_time", DateUtils.StD(shop_take_create_time,"yyyy-MM-dd"));
        }
        return Result.generate(0,"select take success",takeService.selA(map,pageIndex,pageSize));
    }

    /**
     * 根据id修改收货地址信息
     * @param takeModel
     * @return
     */
    public Result updTake(TakeModel takeModel){
        int res = takeService.update(takeModel);
        if (res<0){
            return Result.generate(1,"update take fail ",null);
        }
        return Result.generate(0,"update take success",takeModel);
    }

    /**
     * 删除收货地址
      * @return shop_take_id
     */
    public Result delTake(Integer shop_take_id){
        int i = takeService.delById(shop_take_id);
        if (i<0){
            return Result.generate(0,"delet take fail",null);
        }else {
            return Result.generate(0,"delet take success",null);
        }
    }


}