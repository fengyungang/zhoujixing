package com.zhoujixing.api;


import com.zhoujixing.entity.ShopsModel;

import com.zhoujixing.logic.ShopsLogic;
import com.zhoujixing.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 *商铺api层
 */
@io.swagger.annotations.Api(value="shops接口", tags="shops接口")
@RestController
@RequestMapping("api/shops")
public class ShopsApi extends BaseApi {
    @Autowired
    private ShopsLogic shopsLogic;

    /**
     * 添加商铺
     * @param token
     * @param shopsModel
     * @return
     */
    @ApiOperation(value = "添加商铺",notes = "addShops接口的添加商铺信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_shops_shopname", value = "商铺名", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "shop_shops_shopaddress", value = "商铺地址", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "shop_shops_shoptel", value = "商铺电话", required = true, dataType = "String", paramType = "form")
    })
    @PostMapping("/addShops")
    public Result addShops(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      ShopsModel shopsModel)
    {
        return shopsLogic.addShops(shopsModel);
    }

    /**
     * 删除商铺
     * @param token
     * @param shop_shops_id
     * @return
     */
    @ApiOperation(value = "删除商铺",notes = "delShops接口的删除商铺信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_shops_id", value = "商铺表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @DeleteMapping("/delShops")
    public Result delShops(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      Integer shop_shops_id)
    {
        return shopsLogic.delShops(shop_shops_id);
    }

    /**
     * 查询所有的商铺信息列表（可按条件模糊查询）
     * @param token
     * @param shop_shops_shopname
     * @param shop_shops_shopaddress
     * @param shop_shops_shoptel
     * @param shop_shops_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有的商铺信息列表（可按条件模糊查询）",notes = "selAShops接口的查询所有的商铺信息列表方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_shops_shopname", value = "商铺名", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_shops_shopaddress", value = "商铺地址", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_shops_shoptel", value = "商铺电话", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_shops_create_time", value = "创建时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selAShops")
    public Result selAShops(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                             String shop_shops_shopname,String shop_shops_shopaddress, String shop_shops_shoptel,String shop_shops_create_time,Integer pageIndex,Integer pageSize)
    {

        return shopsLogic.selAll(shop_shops_shopname,shop_shops_shopaddress,shop_shops_shoptel,shop_shops_create_time,pageIndex,pageSize);
    }

    /**
     * 根据id修改商铺信息
     * @param token
     * @param shopsModel
     * @return
     */
   @ApiOperation(value = "根据id修改商铺信息",notes = "updShops接口的根据id修改商铺信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_shops_id", value = "商铺表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @PutMapping("/updShops")
    public Result updShops(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              ShopsModel shopsModel)
    {
        return shopsLogic.updShops(shopsModel);
    }

    /**
     * 根据id查询商铺
     * @param token
     * @param shop_shops_id
     * @return
     */
    @ApiOperation(value = "根据id查询商铺",notes = "selOShops接口的根据id查询商铺信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_shops_id", value = "商铺表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selOShops")
    public Result selOShops(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer shop_shops_id)
    {
        return shopsLogic.getById(shop_shops_id);
    }


}