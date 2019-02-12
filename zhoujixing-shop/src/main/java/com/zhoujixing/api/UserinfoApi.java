package com.zhoujixing.api;


import com.zhoujixing.entity.UserinfoModel;

import com.zhoujixing.logic.UserinfoLogic;
import com.zhoujixing.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


/**
 * 用户信息表api层
 */
@io.swagger.annotations.Api(value="userinfo接口", tags="userinfo接口")
@RestController
@RequestMapping("api/usernfo")
public class UserinfoApi extends BaseApi {
    @Autowired
    private UserinfoLogic userinfoLogic;

    /**
     * 添加用户信息
     * @param token
     * @param userinfoModel
     * @return
     */
    @ApiOperation(value = "添加用户信息",notes = "addUserinfo接口的添加用户信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "关联外键用户表的主键id", required = true, dataType = "Integer", paramType = "form")
    })
    @PostMapping("/addUserinfo")
    public Result addUserinfo(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      UserinfoModel userinfoModel)
    {
        return userinfoLogic.addUserinfo(userinfoModel);
    }

    /**
     * 删除用户信息
     * @param token
     * @param shop_userinfo_id
     * @return
     */
    @ApiOperation(value = "删除用户信息",notes = "delUserinfo接口的删除用户信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_userinfo_id", value = "用户信息表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @DeleteMapping("/delUserinfo")
    public Result delUserinfo(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      Integer shop_userinfo_id)
    {
        return userinfoLogic.delUserinfo(shop_userinfo_id);
    }

    /**
     * 查询所有的用户信息列表（可按条件模糊查询）
     * @param token
     * @param user_id
     * @param shop_userinfo_associator
     * @param shop_userinfo_balance
     * @param shop_userinfo_integral
     * @param shop_userinfo_integral
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有的用户信息列表（可按条件模糊查询）",notes = "selAUserinfo接口的查询所有的用户信息列表方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "关联外键用户表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_userinfo_associator", value = "是否会员（0不是，1是）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_userinfo_balance", value = "余额", required = false, dataType = "bigdecimal", paramType = "query"),
            @ApiImplicitParam(name = "shop_userinfo_integral", value = "积分", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_userinfo_create_time", value = "创建时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selAUserinfo")
    public Result selAUserinfo(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer user_id, String shop_userinfo_associator, BigDecimal shop_userinfo_balance,Integer shop_userinfo_integral,String shop_userinfo_create_time,Integer pageIndex,Integer pageSize)
    {
        return userinfoLogic.selAll(user_id,shop_userinfo_associator,shop_userinfo_balance,shop_userinfo_integral,shop_userinfo_associator,pageIndex,pageSize);
    }

    /**
     * 根据id修改用户信息
     * @param token
     * @param userinfoModel
     * @return
     */
   @ApiOperation(value = "根据id修改用户信息",notes = "updUserinfo接口的根据id修改用户信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_userinfo_id", value = "用户信息表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @PutMapping("/updUserinfo")
    public Result updUserinfo(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              UserinfoModel userinfoModel)
    {
        return userinfoLogic.updUserinfo(userinfoModel);
    }

    /**
     * 根据id查询用户信息
     * @param token
     * @param shop_userinfo_id
     * @return
     */
    @ApiOperation(value = "根据id查询用户信息",notes = "selOUserinfo接口的根据id查询用户信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_userinfo_id", value = "用户信息表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selOUserinfo")
    public Result selOUserinfo(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer shop_userinfo_id)
    {
        return userinfoLogic.getById(shop_userinfo_id);
    }


}