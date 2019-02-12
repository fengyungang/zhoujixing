package com.zhoujixing.logic;


import com.zhoujixing.entity.CartModel;
import com.zhoujixing.entity.CategoryModel;
import com.zhoujixing.service.CartService;
import com.zhoujixing.service.CategoryService;
import com.zhoujixing.utils.DateUtils;
import com.zhoujixing.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 分类表逻辑层
 */
@Component
public class CategoryLogic {
    @Autowired
    private CategoryService categoryService;
    /**
     * 在分类表添加商品分类
     * @param categoryModel
     * @return
     */
    public Result addCategory(CategoryModel categoryModel){
        categoryModel.setShop_category_display("0");
        categoryModel.setShop_category_create_time(new Date());

        int res = categoryService.add(categoryModel);
        return Result.generate(0,"add category success",categoryModel);
    }

    /**
     * 根据id查询分类信息
     * @param shop_category_id
     * @return
     */
    public Result getById(Integer shop_category_id){
        CategoryModel categoryModel = categoryService.getById(shop_category_id);
        return Result.generate(0,"select category success",categoryModel);
    }

    /**
     * 查询分类表里所有的分类信息列表（可按条件模糊查询）
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
    public Result selAll(Integer shop_category_pid, Integer shop_category_sort, String shop_category_cname,String shop_category_keywords, String shop_category_title,String shop_category_description,String shop_category_display,String shop_category_create_time,Integer pageIndex,Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("shop_category_pid",shop_category_pid);
        map.put("shop_category_sort",shop_category_sort);
        map.put("shop_category_cname",shop_category_cname);
        map.put("shop_category_keywords",shop_category_keywords);
        map.put("shop_category_title",shop_category_title);
        map.put("shop_category_description",shop_category_description);
        map.put("shop_category_display",shop_category_display);
        if (shop_category_create_time!=null&&!"".equals(shop_category_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("shop_category_create_time", DateUtils.StD(shop_category_create_time,"yyyy-MM-dd"));
        }
        return Result.generate(0,"select category success",categoryService.selA(map,pageIndex,pageSize));
    }

    /**
     * 根据id修改分类信息
     * @param categoryModel
     * @return
     */
    public Result updCategory(CategoryModel categoryModel){
        int res = categoryService.update(categoryModel);
        if (res<0){
            return Result.generate(1,"update category fail ",null);
        }
        return Result.generate(0,"update category success",categoryModel);
    }

    /**
     * 在逻辑上删除分类信息
      * @return shop_category_id
     */
    public Result delCategory(Integer shop_category_id){
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setShop_category_id(shop_category_id);
        categoryModel.setShop_category_display("1");

        int i = categoryService.update(categoryModel);
        if (i<0){
            return Result.generate(0,"delet category fail",null);
        }else {
            return Result.generate(0,"delet category success",categoryModel);
        }
    }


}