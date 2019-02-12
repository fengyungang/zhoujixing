package com.zhoujixing.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoujixing.dao.ShopsMapper;
import com.zhoujixing.dao.TakeMapper;
import com.zhoujixing.entity.ShopsModel;
import com.zhoujixing.entity.TakeModel;
import com.zhoujixing.service.ShopsService;
import com.zhoujixing.service.TakeService;
import com.zhoujixing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TakeServiceImpl implements TakeService {

    @Autowired
    private TakeMapper takeMapper;

    /**
     * 添加方法
     * @param takeModel
     * @return
     */
    @Override
    public int add(TakeModel takeModel) {
        return takeMapper.add(takeModel);
    }

    /**
     * 根据id查询一条信息
     * @param shop_take_id
     * @return
     */
    @Override
    public TakeModel getById(Integer shop_take_id) {
        return takeMapper.getById(shop_take_id);
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
        List<TakeModel> takeModelList = takeMapper.selA(map);
        PageInfo<TakeModel> pageInfo = new PageInfo<>(page.getResult());
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();
        map.put("takeModelList",takeModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    @Override
    public List<TakeModel> selA(Map<String, Object> map) {
        return takeMapper.selA(map);
    }

    /**
     * 根据id修改某条信息
     * @param takeModel
     * @return
     */
    @Override
    public int update(TakeModel takeModel) {
        return takeMapper.update(takeModel);
    }

    /**
     * 根据id删除客户信息（物理删除）
     * @param shop_take_id
     * @return
     */
    @Override
    public int delById(Integer shop_take_id) {
        return takeMapper.delById(shop_take_id);
    }
}