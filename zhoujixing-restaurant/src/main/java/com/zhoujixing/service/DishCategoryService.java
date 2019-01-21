package com.zhoujixing.service;

import com.zhoujixing.entity.DishCategory;

import java.util.List;

public interface DishCategoryService {

    /**
     * 添加菜品类型信息
     * @param dishCategory
     * @return
     */
    boolean addCategory(DishCategory dishCategory);

    /**
     * 查询所有菜品类型信息
     * @return
     */
    List<DishCategory> getAllCategory();

    /**
     * 根据id查询菜品类型
     * @param id
     * @return
     */
    DishCategory getCategoryById(Integer id);

    /**
     * 根据菜品类型名称查询菜品类型信息
     * @param categoryName
     * @return
     */
    DishCategory getCategoryByCategoryName(String categoryName);

    /**
     * 根据id删除菜品类型信息
     * @param id
     * @return
     */
    boolean removeCategory(Integer id);
}
