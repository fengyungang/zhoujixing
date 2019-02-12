package com.zhoujixing.service;

import com.zhoujixing.entity.CartModel;
import com.zhoujixing.entity.CategoryModel;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    /**
     * 添加方法
     * @param categoryModel
     * @return
     */
    int add(CategoryModel categoryModel);

    /**
     * 根据id查询一条信息
     * @param shop_category_id
     * @return
     */
    CategoryModel getById(Integer shop_category_id);

    /**
     * 查询所有信息
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Map<String,Object> selA(Map<String, Object> map, Integer pageIndex, Integer pageSize);

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    List<CategoryModel> selA(Map<String, Object> map);

    /**
     * 根据id修改某条信息
     * @param categoryModel
     * @return
     */
    int update(CategoryModel categoryModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param shop_category_id
     * @return
     */
    int delById(Integer shop_category_id);

}
