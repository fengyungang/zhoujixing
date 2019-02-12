package com.zhoujixing.api;


import com.zhoujixing.entity.CollectModel;

import com.zhoujixing.logic.CollectLogic;
import com.zhoujixing.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *收藏表api层
 */
@io.swagger.annotations.Api(value="collect接口", tags="collect接口")
@RestController
@RequestMapping("api/collect")
public class CollectApi extends BaseApi {
    @Autowired
    private CollectLogic collectLogic;

    /**
     * 添加商品到收藏表里
     * @param token
     * @param collectModel
     * @return
     */
    @ApiOperation(value = "添加商品到收藏表里",notes = "addCollect接口的添加商品到收藏表里方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "关联外键用户表的主键id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "shop_goods_id", value = "关联外键商品表的主键id", required = true, dataType = "Integer", paramType = "form")
    })
    @PostMapping("/addCollect")
    public Result addCollect(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      CollectModel collectModel)
    {
        return collectLogic.addCollect(collectModel);
    }

    /**
     * 删除收藏信息
     * @param token
     * @param shop_collect_id
     * @return
     */
    @ApiOperation(value = "删除收藏信息",notes = "delCollect接口的删除收藏信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_collect_id", value = "收藏表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @DeleteMapping("/delCollect")
    public Result delCollect(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      Integer shop_collect_id)
    {
        return collectLogic.delCollect(shop_collect_id);
    }

    /**
     * 查询收藏表里所有的信息列表（可按条件模糊查询）
     * @param token
     * @param user_id
     * @param shop_goods_id
     * @param shop_collect_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询收藏表里所有的信息列表（可按条件模糊查询）",notes = "selACollect接口的查询收藏表里所有的信息列表方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "关联外键用户表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_goods_id", value = "关联外键商品表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_collect_create_time", value = "创建时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selACollect")
    public Result selACollect(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer user_id, Integer shop_goods_id, String shop_collect_create_time,Integer pageIndex,Integer pageSize)
    {

        return collectLogic.selAll(user_id, shop_goods_id, shop_collect_create_time, pageIndex, pageSize);
    }

    /**
     * 根据id修改收藏表信息
     * @param token
     * @param collectModel
     * @return
     */
   @ApiOperation(value = "根据id修改收藏表信息",notes = "updCollect接口的根据id修改收藏表信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_collect_id", value = "收藏表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @PutMapping("/updCollect")
    public Result updCollect(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              CollectModel collectModel)
    {
        return collectLogic.updCollect(collectModel);
    }

    /**
     * 根据id查询收藏信息
     * @param token
     * @param shop_collect_id
     * @return
     */
    @ApiOperation(value = "根据id查询收藏信息",notes = "selOCollect接口的根据id查询收藏信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_collect_id", value = "收藏表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selOCollect")
    public Result selOCollect(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer shop_collect_id)
    {
        return collectLogic.getById(shop_collect_id);
    }


}