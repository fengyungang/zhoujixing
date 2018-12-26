package com.zhoujixing.service;

import com.zhoujixing.entity.Dish;

import java.util.List;

public interface DishService {

    /**
     * 插入菜品的方法
     * @param dish
     * @return
     */
    boolean addDish(Dish dish);

    /**
     * 查询所有菜品的方法
     * @param categoryId
     * @return
     */
    List<Dish> getByCategoryId(Integer categoryId);

    /**
     * 根据id查询菜品信息
     * @param id
     * @return
     */
    Dish getById(Integer id);

    /**
     * 根据菜品名称查询菜品信息
     * @param dishName
     * @return
     */
    Dish getByDishName(String dishName);

    /**
     * 修改菜品信息
     * @param dish
     * @return
     */
    boolean modifyDish(Dish dish);

    /**
     * 根据id删除菜品信息
     * @param id
     * @return
     */
    boolean removeDish(Integer id);
}
