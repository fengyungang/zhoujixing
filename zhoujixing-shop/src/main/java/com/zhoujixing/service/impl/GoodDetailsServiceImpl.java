package com.zhoujixing.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoujixing.dao.CommentMapper;
import com.zhoujixing.dao.GoodDetailsMapper;
import com.zhoujixing.entity.CommentModel;
import com.zhoujixing.entity.GoodDetailsModel;
import com.zhoujixing.service.CommentService;
import com.zhoujixing.service.GoodDetailsService;
import com.zhoujixing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodDetailsServiceImpl implements GoodDetailsService {

    @Autowired
    private GoodDetailsMapper goodDetailsMapper;

    /**
     * 添加方法
     * @param goodDetailsModel
     * @return
     */
    @Override
    public int add(GoodDetailsModel goodDetailsModel) {
        return goodDetailsMapper.add(goodDetailsModel);
    }

    /**
     * 根据id查询一条信息
     * @param shop_good_details_id
     * @return
     */
    @Override
    public GoodDetailsModel getById(Integer shop_good_details_id) {
        return goodDetailsMapper.getById(shop_good_details_id);
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
        List<GoodDetailsModel> goodDetailsModelList = goodDetailsMapper.selA(map);
        PageInfo<GoodDetailsModel> pageInfo = new PageInfo<>(page.getResult());
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();
        map.put("goodDetailsModelList",goodDetailsModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    @Override
    public List<GoodDetailsModel> selA(Map<String, Object> map) {
        return goodDetailsMapper.selA(map);
    }

    /**
     * 根据id修改某条信息
     * @param goodDetailsModel
     * @return
     */
    @Override
    public int update(GoodDetailsModel goodDetailsModel) {
        return goodDetailsMapper.update(goodDetailsModel);
    }

    /**
     * 根据id删除客户信息（物理删除）
     * @param shop_good_details_id
     * @return
     */
    @Override
    public int delById(Integer shop_good_details_id) {
        return goodDetailsMapper.delById(shop_good_details_id);
    }
}
