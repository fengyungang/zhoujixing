package com.zhoujixing.api;

import com.zhoujixing.entity.GoodDetailsModel;

import com.zhoujixing.logic.GoodDetailsLogic;
import com.zhoujixing.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * 商品详情表api层
 */
@io.swagger.annotations.Api(value="goodDetails接口", tags="goodDetails接口")
@RestController
@RequestMapping("api/goodDetails")
public class GoodDetailsApi extends BaseApi {
    @Autowired
    private GoodDetailsLogic goodDetailsLogic;

    /**
     * 添加商品详情
     * @param token
     * @param goodDetailsModel
     * @return
     */
    @ApiOperation(value = "添加商品详情",notes = "addGoodDetails接口添加商品详情信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_goods_id", value = "关联外键商品表的主键id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "shop_good_details_detail", value = "商品描述", required = true, dataType = "String", paramType = "form")
    })
    @PostMapping("/addGoodDetails")
    public Result addGoodDetails(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      GoodDetailsModel goodDetailsModel)
    {
        return goodDetailsLogic.addGoodDetails(goodDetailsModel);
    }

    /**
     * 删除商品详情
     * @param token
     * @param shop_good_details_id
     * @return
     */
    @ApiOperation(value = "删除商品详情",notes = "delGoodDetails接口的删除商品详情信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_good_details_id", value = "商品详情表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @DeleteMapping("/delGoodDetails")
    public Result delGoodDetails(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      Integer shop_good_details_id)
    {
        return goodDetailsLogic.delGoodDetails(shop_good_details_id);
    }

    /**
     * 查询所有的商品详情信息列表（可按条件模糊查询）
     * @param token
     * @param user_id
     * @param shop_good_details_detail
     * @param shop_good_details_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有的商品详情信息列表（可按条件模糊查询）",notes = "selAGoodDetails接口的查询所有的商品详情信息列表方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_goods_id", value = "关联外键商品表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_good_details_detail", value = "商品描述", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_good_details_create_time", value = "创建时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selAGoodDetails")
    public Result selAGoodDetails(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer user_id, String shop_good_details_detail,String shop_good_details_create_time,Integer pageIndex,Integer pageSize)
    {

        return goodDetailsLogic.selAll(user_id,shop_good_details_detail,shop_good_details_create_time,pageIndex,pageSize);
    }

    /**
     * 根据id修改商品详情信息
     * @param token
     * @param goodDetailsModel
     * @return
     */
   @ApiOperation(value = "根据id修改商品详情信息",notes = "updGoodDetails接口的根据id修改商品详情信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_good_details_id", value = "商品详情表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @PutMapping("/updGoodDetaila")
    public Result updGoodDetaila(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              GoodDetailsModel goodDetailsModel)
    {
        return goodDetailsLogic.updGoodDetails(goodDetailsModel);
    }

    /**
     * 根据id查询商品的详情
     * @param token
     * @param shop_good_details_id
     * @return
     */
    @ApiOperation(value = "根据id查询商品的详情",notes = "selOGoodDetails接口的根据id查询商品的详情信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_good_details_id", value = "商品详情表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selOGoodDetails")
    public Result selOGoodDetails(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer shop_good_details_id)
    {
        return goodDetailsLogic.getById(shop_good_details_id);
    }


}