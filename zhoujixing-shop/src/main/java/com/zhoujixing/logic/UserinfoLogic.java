package com.zhoujixing.logic;


import com.zhoujixing.entity.OrderModel;
import com.zhoujixing.entity.UserinfoModel;
import com.zhoujixing.service.OrderService;
import com.zhoujixing.service.UserinfoService;
import com.zhoujixing.utils.DateUtils;
import com.zhoujixing.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户信息表逻辑层
 */
@Component
public class UserinfoLogic {
    @Autowired
    private UserinfoService userinfoService;
    /**
     * 添加用户信息
     * @param userinfoModel
     * @return
     */
    public Result addUserinfo(UserinfoModel userinfoModel){
        userinfoModel.setShop_userinfo_associator("0");
        /*userinfoModel.setShop_userinfo_balance(new BigDecimal("0.00"));*/
        userinfoModel.setShop_userinfo_balance(new BigDecimal("0").setScale(2));
        userinfoModel.setShop_userinfo_integral(0);
        int res = userinfoService.add(userinfoModel);
        return Result.generate(0,"add userinfo success",userinfoModel);
    }

    /**
     * 根据id查询用户信息
     * @param shop_userinfo_id
     * @return
     */
    public Result getById(Integer shop_userinfo_id){
        UserinfoModel userinfoModel = userinfoService.getById(shop_userinfo_id);
        return Result.generate(0,"select userinfo success",userinfoModel);
    }

    /**
     *  查询所有的用户信息列表（可按条件模糊查询）
     * @param user_id
     * @param shop_userinfo_associator
     * @param shop_userinfo_balance
     * @param shop_userinfo_integral
     * @param shop_userinfo_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result selAll(Integer user_id, String shop_userinfo_associator, BigDecimal shop_userinfo_balance, Integer shop_userinfo_integral, String shop_userinfo_create_time,Integer pageIndex, Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("user_id",user_id);
        map.put("shop_userinfo_associator",shop_userinfo_associator);
        map.put("shop_userinfo_balance",shop_userinfo_balance);
        map.put("shop_userinfo_integral",shop_userinfo_integral);

        if (shop_userinfo_create_time!=null&&!"".equals(shop_userinfo_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("shop_userinfo_create_time", DateUtils.StD(shop_userinfo_create_time,"yyyy-MM-dd"));
        }
        return Result.generate(0,"select userinfo success",userinfoService.selA(map,pageIndex,pageSize));
    }

    /**
     * 根据id修改用户信息
     * @param userinfoModel
     * @return
     */
    public Result updUserinfo(UserinfoModel userinfoModel){
        int res = userinfoService.update(userinfoModel);
        if (res<0){
            return Result.generate(1,"update userinfo fail ",null);
        }
        return Result.generate(0,"update userinfo success",userinfoModel);
    }

    /**
     * 删除用户信息
      * @return shop_userinfo_id
     */
    public Result delUserinfo(Integer shop_userinfo_id){
        int i = userinfoService.delById(shop_userinfo_id);
        if (i<0){
            return Result.generate(0,"delet userinfo fail",null);
        }else {
            return Result.generate(0,"delet userinfo success",null);
        }
    }


}