package com.zhoujixing.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoujixing.conf.datasources.DataSourceNames;
import com.zhoujixing.conf.datasources.annotation.DataSource;
import com.zhoujixing.dao.CartMapper;

import com.zhoujixing.entity.CartModel;

import com.zhoujixing.service.CartService;

import com.zhoujixing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    /**
     * 添加方法
     * @param cartModel
     * @return
     */
    @Override
    public int add(CartModel cartModel) {
        return cartMapper.add(cartModel);
    }

    /**
     * 根据id查询一条信息
     * @param shop_cart_id
     * @return
     */
    @Override
    /*@DataSource(name = DataSourceNames.SECOND)*/
    public CartModel getById(Integer shop_cart_id) {
        return cartMapper.getById(shop_cart_id);
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
        List<CartModel> cartModelList = cartMapper.selA(map);
        PageInfo<CartModel> pageInfo = new PageInfo<>(page.getResult());
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();
        map.put("cartModelList",cartModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    @Override
    public List<CartModel> selA(Map<String, Object> map) {
        return cartMapper.selA(map);
    }

    /**
     * 根据id修改某条信息
     * @param cartModel
     * @return
     */
    @Override
    public int update(CartModel cartModel) {
        return cartMapper.update(cartModel);
    }

    /**
     * 根据id删除客户信息（物理删除）
     * @param shop_cart_id
     * @return
     */
    @Override
    public int delById(Integer shop_cart_id) {
        return cartMapper.delById(shop_cart_id);
    }
}
