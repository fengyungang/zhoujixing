package com.zhoujixing.api;


import com.zhoujixing.entity.TakeModel;

import com.zhoujixing.logic.TakeLogic;
import com.zhoujixing.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * 收货地址表api层
 */
@io.swagger.annotations.Api(value="take接口", tags="take接口")
@RestController
@RequestMapping("api/take")
public class TakeApi extends BaseApi {
    @Autowired
    private TakeLogic takeLogic;

    /**
     * 添加收货地址
     * @param token
     * @param takeModel
     * @return
     */
    @ApiOperation(value = "添加收货地址",notes = "addTake接口的添加收货地址信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "关联外键用户表的主键id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "shop_take_consignee", value = "收货人", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "shop_take_province", value = "省", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "shop_take_city", value = "市", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "shop_take_county", value = "县(区)", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "shop_take_street", value = "街道地址", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "shop_take_tel", value = "电话", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "shop_take_postcode", value = "邮编地址", required = true, dataType = "String", paramType = "form")
    })
    @PostMapping("/addTake")
    public Result addTake(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      TakeModel takeModel)
    {
        return takeLogic.addTake(takeModel);
    }

    /**
     *删除收货地址
     * @param token
     * @param shop_take_id
     * @return
     */
    @ApiOperation(value = "删除收货地址",notes = "delTake接口的删除收货地址信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_take_id", value = "收货地址表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @DeleteMapping("/delTake")
    public Result delTake(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      Integer shop_take_id)
    {
        return takeLogic.delTake(shop_take_id);
    }

    /**
     * 查询所有的收货地址信息列表（可按条件模糊查询）
     * @param token
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
    @ApiOperation(value = "查询所有的收货地址信息列表（可按条件模糊查询）",notes = "selATake接口的查询所有的收货地址信息列表方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "关联外键用户表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_take_consignee", value = "收货人", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_take_province", value = "省", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_take_city", value = "市", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_take_county", value = "县", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_take_street", value = "街道地址", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_take_tel", value = "电话", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_take_postcode", value = "邮编地址", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_take_create_time", value = "创建时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selATake")
    public Result selATake(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer user_id, String shop_take_consignee, String shop_take_province,String shop_take_city,String shop_take_county, String shop_take_street,String shop_take_tel,String shop_take_postcode,String shop_take_create_time,Integer pageIndex,Integer pageSize)
    {

        return takeLogic.selAll(user_id,shop_take_consignee,shop_take_province,shop_take_city,shop_take_county,shop_take_street,shop_take_tel,shop_take_postcode,shop_take_create_time,pageIndex,pageSize);
    }

    /**
     * 根据id修改收货地址信息
     * @param token
     * @param takeModel
     * @return
     */
   @ApiOperation(value = "根据id修改收货地址信息",notes = "updTake接口的根据id修改收货地址信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_take_id", value = "收货地址表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @PutMapping("/updTake")
    public Result updTake(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              TakeModel takeModel)
    {
        return takeLogic.updTake(takeModel);
    }

    /**
     * 根据id查询收货地址信息
     * @param token
     * @param shop_take_id
     * @return
     */
    @ApiOperation(value = "根据id查询收货地址信息",notes = "selOTake接口的根据id查询收货地址信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_take_id", value = "收货地址表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selOTake")
    public Result selOTake(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer shop_take_id)
    {
        return takeLogic.getById(shop_take_id);
    }


}