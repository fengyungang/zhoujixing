package com.zhoujixing.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoujixing.dao.CartMapper;
import com.zhoujixing.dao.CategoryMapper;
import com.zhoujixing.entity.CartModel;
import com.zhoujixing.entity.CategoryModel;
import com.zhoujixing.service.CartService;
import com.zhoujixing.service.CategoryService;
import com.zhoujixing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 添加方法
     * @param categoryModel
     * @return
     */
    @Override
    public int add(CategoryModel categoryModel) {
        return categoryMapper.add(categoryModel);
    }

    /**
     * 根据id查询一条信息
     * @param shop_category_id
     * @return
     */
    @Override
    public CategoryModel getById(Integer shop_category_id) {
        return categoryMapper.getById(shop_category_id);
    }

    /**
     * 查询所有信息
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> selA(Map<String, Object> map, Integer pageIndex, Integer pageSize) {
        Page page = PageHelper.startPage(pageIndex,pageSize);
        List<CategoryModel> categoryModelList = categoryMapper.selA(map);
        PageInfo<CategoryModel> pageInfo = new PageInfo<>(page.getResult());
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();
        map.put("categoryModelList",categoryModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    @Override
    public List<CategoryModel> selA(Map<String, Object> map) {
        return categoryMapper.selA(map);
    }

    /**
     *  根据id修改某条信息
     * @param categoryModel
     * @return
     */
    @Override
    public int update(CategoryModel categoryModel) {
        return categoryMapper.update(categoryModel);
    }

    /**
     * 根据id删除客户信息（物理删除）
     * @param shop_category_id
     * @return
     */
    @Override
    public int delById(Integer shop_category_id) {
        return categoryMapper.delById(shop_category_id);
    }
}
