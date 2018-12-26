package com.zhoujixing.controller;

import com.zhoujixing.entity.Dish;
import com.zhoujixing.entity.DishCategory;
import com.zhoujixing.service.DishCategoryService;
import com.zhoujixing.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private DishCategoryService dishCategoryService;

    @RequestMapping("/adddish")
    public Map<Object,String> addDish(String dishName,Double price,String depict,Integer categoryId){
        Map<Object,String> modelMap = new HashMap<>();
        Dish dish1 = dishService.getByDishName(dishName);
        if (dish1 == null){
            Dish dish = new Dish();
            dish.setDishName(dishName);
            dish.setPrice(price);
            dish.setDepict(depict);
            dish.setCategoryId(categoryId);
            dish.setCreateTime(new Date());
            dishService.addDish(dish);
            modelMap.put(1,"添加成功！");
        }else {
            modelMap.put(0,"菜品名称已存在！");
        }
        return modelMap;
    }

    @RequestMapping("/getbycategoryid")
    public Map<String,Object> getByCategoryId(Integer categoryId){
        Map<String,Object> modelMap = new HashMap<>();
        List<Dish> list = dishService.getByCategoryId(categoryId);
        modelMap.put("dishs",list);
        return modelMap;
    }

    @RequestMapping("/getbyid")
    public Map<String,Object> getById(Integer id){
        Map<String,Object> modelMap = new HashMap<>();
        Dish dish = dishService.getById(id);
        modelMap.put("dish",dish);
        return modelMap;
    }

    @RequestMapping("/getbydishname")
    public Map<String,Object> getByDishName(String dishName){
        Map<String,Object> modelMap = new HashMap<>();
        Dish dish = dishService.getByDishName(dishName);
        modelMap.put("dish",dish);
        return modelMap;
    }

    @RequestMapping("/modifydish")
    public Map<Object,String> modifyDish(String dishName,Double price,String depict,Integer categoryId){
        Map<Object,String> modelMap = new HashMap<>();
        Dish dish = dishService.getByDishName(dishName);
        if (dish != null){
            dish.setPrice(price);
            dish.setDepict(depict);
            dish.setCategoryId(categoryId);
            dish.setUpdateTime(new Date());
            dishService.modifyDish(dish);
            modelMap.put(1,"修改成功！");
        }else {
            modelMap.put(0,"菜品名称不存在！");
        }
        return modelMap;
    }

    @RequestMapping("/removedish")
    public Map<Object,String> removeDish(Integer id){
        Map<Object,String> modelMap = new HashMap<>();
        if (dishService.removeDish(id)){
            modelMap.put(1,"删除成功！");
        }else {
            modelMap.put(0,"菜品不存在！");
        }
        return modelMap;
    }


    @RequestMapping("/addcategory")
    public Map<Object,String> addCategory(String categoryName){
        Map<Object,String> modelMap = new HashMap<>();
        DishCategory dishCategory1 = dishCategoryService.getCategoryByCategoryName(categoryName);
        if (dishCategory1 == null){
            DishCategory dishCategory = new DishCategory();
            dishCategory.setCategoryName(categoryName);
            dishCategory.setCreateTime(new Date());
            dishCategoryService.addCategory(dishCategory);
            modelMap.put(1,"添加成功！");
        }else {
            modelMap.put(0,"类型已存在！");
        }
        return modelMap;
    }

    @RequestMapping("/getdish")
    public Map<Object,Object> getDish(String categoryName){
        Map<Object,Object> modelMap = new HashMap<>();
        DishCategory dishCategory = dishCategoryService.getCategoryByCategoryName(categoryName);
        List<Dish> list = dishService.getByCategoryId(dishCategory.getId());
        modelMap.put(categoryName,list);
        return modelMap;
    }

    @RequestMapping("/removecategory")
    public Map<Object,String> removeCategory(Integer id){
        Map<Object,String> modelMap = new HashMap<>();
        if (dishCategoryService.removeCategory(id)){
            modelMap.put(1,"删除成功！");
        }else {
            modelMap.put(0,"类型不存在！");
        }
        return modelMap;
    }

}
