package com.zhoujixing.api;


import com.zhoujixing.entity.CategoryModel;

import com.zhoujixing.logic.CategoryLogic;
import com.zhoujixing.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * 分类表api层
 */
@io.swagger.annotations.Api(value="category接口", tags="category接口")
@RestController
@RequestMapping("api/category")
public class CategoryApi extends BaseApi {
    @Autowired
    private CategoryLogic categoryLogic;

    /**
     * 在分类表添加商品分类
     * @param token
     * @param categoryModel
     * @return
     */
    @ApiOperation(value = "在分类表添加商品分类",notes = "addCategory接口的在分类表添加商品分类信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_category_pid", value = "父id", required = false, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "shop_category_sort", value = "类型排序", required = false, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "shop_category_cname", value = "分类名", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "shop_category_keywords", value = "分类关键字", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "shop_category_title", value = "分类标题", required = false, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "shop_category_description", value = "分类描述", required = false, dataType = "String", paramType = "form")
    })
    @PostMapping("/addCategory")
    public Result addCategory(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      CategoryModel categoryModel)
    {
        return categoryLogic.addCategory(categoryModel);
    }

    /**
     * 删除分类信息（逻辑删除）
     * @param token
     * @param shop_category_id
     * @return
     */
    @ApiOperation(value = "删除分类信息",notes = "delCategory接口的删除分类信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_category_id", value = "分类表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @PutMapping("/delCategory")
    public Result delCategory(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      Integer shop_category_id)
    {
        return categoryLogic.delCategory(shop_category_id);
    }

    /**
     * 查询分类表里所有的分类信息列表（可按条件模糊查询）
     * @param token
     * @param shop_category_pid
     * @param shop_category_sort
     * @param shop_category_cname
     * @param shop_category_keywords
     * @param shop_category_title
     * @param shop_category_description
     * @param shop_category_display
     * @param shop_category_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询分类表里所有的分类信息列表（可按条件模糊查询）",notes = "selACategory接口的查询分类表里所有的分类信息列表方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_category_pid", value = "父id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_category_sort", value = "类型排序", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_category_cname", value = "分类名", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_category_keywords", value = "分类关键字", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_category_title", value = "分类标题", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_category_description", value = "分类描述", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_category_display", value = "是否显示（0显示，1不显示）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_category_create_time", value = "创建时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selACategory")
    public Result selACategory(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer shop_category_pid, Integer shop_category_sort, String shop_category_cname,String shop_category_keywords,String shop_category_title, String shop_category_description,String shop_category_display,String shop_category_create_time, Integer pageIndex,Integer pageSize)
    {

        return categoryLogic.selAll(shop_category_pid, shop_category_sort, shop_category_cname, shop_category_keywords, shop_category_title, shop_category_description,shop_category_display,shop_category_create_time, pageIndex, pageSize);
    }

    /**
     * 根据id修改分类信息
     * @param token
     * @param categoryModel
     * @return
     */
   @ApiOperation(value = "根据id修改分类信息",notes = "updCategory接口的根据id修改分类信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_category_id", value = "分类表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @PutMapping("/updCategory")
    public Result updCategory(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              CategoryModel categoryModel)
    {
        return categoryLogic.updCategory(categoryModel);
    }

    /**
     * 根据id查询分类信息
     * @param token
     * @param shop_category_id
     * @return
     */
    @ApiOperation(value = "根据id查询分类信息",notes = "selOCategory接口的根据id查询分类信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_category_id", value = "分类表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selOCategory")
    public Result selOCategory(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer shop_category_id)
    {
        return categoryLogic.getById(shop_category_id);
    }


}