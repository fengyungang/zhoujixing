package com.zhoujixing.service.impl;

import com.zhoujixing.entity.DishCategory;
import com.zhoujixing.mapper.DishCategoryMapper;
import com.zhoujixing.service.DishCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dishCategoryService")
public class DishCategoryServiceImpl implements DishCategoryService {

    @Autowired
    private DishCategoryMapper dishCategoryMapper;

    @Override
    public boolean addCategory(DishCategory dishCategory) {
        boolean result = false;
        if (dishCategoryMapper.insertCategory(dishCategory)>0){
            result = true;
        }
        return result;
    }

    @Override
    public List<DishCategory> getAllCategory() {
        return dishCategoryMapper.selectAllCategory();
    }

    @Override
    public DishCategory getCategoryById(Integer id) {
        return dishCategoryMapper.selectById(id);
    }

    @Override
    public DishCategory getCategoryByCategoryName(String categoryName) {
        return dishCategoryMapper.selectByCategoryName(categoryName);
    }

    @Override
    public boolean removeCategory(Integer id) {
        boolean result = false;
        if (dishCategoryMapper.deleteCategory(id)>0){
            result = true;
        }
        return result;
    }
}
