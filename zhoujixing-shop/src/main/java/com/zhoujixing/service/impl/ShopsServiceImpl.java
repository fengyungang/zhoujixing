package com.zhoujixing.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoujixing.dao.OrderMapper;
import com.zhoujixing.dao.ShopsMapper;
import com.zhoujixing.entity.OrderModel;
import com.zhoujixing.entity.ShopsModel;
import com.zhoujixing.service.OrderService;
import com.zhoujixing.service.ShopsService;
import com.zhoujixing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShopsServiceImpl implements ShopsService {

    @Autowired
    private ShopsMapper shopsMapper;

    /**
     *添加方法
     * @param shopsModel
     * @return
     */
    @Override
    public int add(ShopsModel shopsModel) {
        return shopsMapper.add(shopsModel);
    }

    /**
     *根据id查询一条信息
     * @param shop_shops_id
     * @return
     */
    @Override
    public ShopsModel getById(Integer shop_shops_id) {
        return shopsMapper.getById(shop_shops_id);
    }

    /**
     *查询所有信息
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> selA(Map<String, Object> map, Integer pageIndex, Integer pageSize) {
        Page page = PageHelper.startPage(pageIndex,pageSize);
        List<ShopsModel> shopsModelList = shopsMapper.selA(map);
        PageInfo<ShopsModel> pageInfo = new PageInfo<>(page.getResult());
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();
        map.put("shopsModelList",shopsModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    @Override
    public List<ShopsModel> selA(Map<String, Object> map) {
        return shopsMapper.selA(map);
    }

    /**
     *根据id修改某条信息
     * @param shopsModel
     * @return
     */
    @Override
    public int update(ShopsModel shopsModel) {
        return shopsMapper.update(shopsModel);
    }

    /**
     * 根据id删除客户信息（物理删除）
     * @param shop_shops_id
     * @return
     */
    @Override
    public int delById(Integer shop_shops_id) {
        return shopsMapper.delById(shop_shops_id);
    }
}
