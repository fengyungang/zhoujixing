package com.zhoujixing.mapper;

import com.zhoujixing.entity.DishCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishCategoryMapper {

    /**
     * 插入菜品类型
     * @param dishCategory
     * @return
     */
    int insertCategory(DishCategory dishCategory);

    /**
     * 查询所有类型信息
     * @return
     */
    List<DishCategory> selectAllCategory();

    /**
     * 根据id查询类型信息
     * @param id
     * @return
     */
    DishCategory selectById(Integer id);

    /**
     * 根据类型名称查询类型信息
     * @param categoryName
     * @return
     */
    DishCategory selectByCategoryName(String categoryName);

    /**
     * 删除菜品类型信息
     * @param id
     * @return
     */
    int deleteCategory(Integer id);

}
