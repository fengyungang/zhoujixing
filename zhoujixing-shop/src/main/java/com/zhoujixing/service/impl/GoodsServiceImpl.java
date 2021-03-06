package com.zhoujixing.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoujixing.dao.GoodDetailsMapper;
import com.zhoujixing.dao.GoodsMapper;
import com.zhoujixing.entity.GoodDetailsModel;
import com.zhoujixing.entity.GoodsModel;
import com.zhoujixing.service.GoodDetailsService;
import com.zhoujixing.service.GoodsService;
import com.zhoujixing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 添加方法
     * @param goodsModel
     * @return
     */
    @Override
    public int add(GoodsModel goodsModel) {
        return goodsMapper.add(goodsModel);
    }

    /**
     * 根据id查询一条信息
     * @param shop_goods_id
     * @return
     */
    @Override
    public GoodsModel getById(Integer shop_goods_id) {
        return goodsMapper.getById(shop_goods_id);
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
        List<GoodsModel> goodsModelList = goodsMapper.selA(map);
        PageInfo<GoodsModel> pageInfo = new PageInfo<>(page.getResult());
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();
        map.put("goodsModelList",goodsModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    @Override
    public List<GoodsModel> selA(Map<String, Object> map) {
        return goodsMapper.selA(map);
    }

    /**
     * 根据id修改某条信息
     * @param goodsModel
     * @return
     */
    @Override
    public int update(GoodsModel goodsModel) {
        return goodsMapper.update(goodsModel);
    }

    /**
     * 根据id删除客户信息（物理删除）
     * @param shop_goods_id
     * @return
     */
    @Override
    public int delById(Integer shop_goods_id) {
        return goodsMapper.delById(shop_goods_id);
    }
}
