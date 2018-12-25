package com.zhoujixing.service.impl;

import com.zhoujixing.entity.Dish;
import com.zhoujixing.mapper.DishMapper;
import com.zhoujixing.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dishService")
public class DishServiceImpl implements DishService {
    @Autowired
    private DishMapper dishMapper;

    @Override
    public boolean addDish(Dish dish) {
        boolean result = false;
        if (dishMapper.insertDish(dish)>0){
            result = true;
        }
        return result;
    }

    @Override
    public List<Dish> getByCategoryId(Integer categoryId) {
        return dishMapper.selectByCategoryId(categoryId);
    }

    @Override
    public Dish getById(Integer id) {
        return dishMapper.selectById(id);
    }

    @Override
    public Dish getByDishName(String dishName) {
        return dishMapper.selectByDishName(dishName);
    }

    @Override
    public boolean modifyDish(Dish dish) {
        boolean result = false;
        if (dishMapper.updateDish(dish)>0){
            result = true;
        }
        return result;
    }

    @Override
    public boolean removeDish(Integer id) {
        boolean result = false;
        if (dishMapper.deleteDish(id)>0){
            result = true;
        }
        return result;
    }
}
