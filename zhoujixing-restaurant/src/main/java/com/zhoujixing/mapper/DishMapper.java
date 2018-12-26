package com.zhoujixing.mapper;

import com.zhoujixing.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishMapper {
    /**
     * 插入菜品的方法
     * @param dish
     * @return
     */
    int insertDish(Dish dish);

    /**
     * 查询所有菜品的方法
     * @param categoryId
     * @return
     */
    List<Dish> selectByCategoryId(Integer categoryId);

    /**
     * 根据id查询菜品信息
     * @param id
     * @return
     */
    Dish selectById(Integer id);

    /**
     * 根据菜品名称查询菜品信息
     * @param dishName
     * @return
     */
    Dish selectByDishName(String dishName);

    /**
     * 修改菜品信息
     * @param dish
     * @return
     */
    int updateDish(Dish dish);

    /**
     * 根据id删除菜品信息
     * @param id
     * @return
     */
    int deleteDish(Integer id);
}
