package com.zhoujixing.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoujixing.dao.CategoryMapper;
import com.zhoujixing.dao.CollectMapper;
import com.zhoujixing.entity.CategoryModel;
import com.zhoujixing.entity.CollectModel;
import com.zhoujixing.service.CategoryService;
import com.zhoujixing.service.CollectService;
import com.zhoujixing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    /**
     * 添加方法
     * @param collectModel
     * @return
     */
    @Override
    public int add(CollectModel collectModel) {
        return collectMapper.add(collectModel);
    }

    /**
     * 根据id查询一条信息
     * @param shop_collect_id
     * @return
     */
    @Override
    public CollectModel getById(Integer shop_collect_id) {
        return collectMapper.getById(shop_collect_id);
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
        List<CollectModel> collectModelList = collectMapper.selA(map);
        PageInfo<CollectModel> pageInfo = new PageInfo<>(page.getResult());
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();
        map.put("collectModelList",collectModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    @Override
    public List<CollectModel> selA(Map<String, Object> map) {
        return collectMapper.selA(map);
    }

    /**
     * 根据id修改某条信息
     * @param collectModel
     * @return
     */
    @Override
    public int update(CollectModel collectModel) {
        return collectMapper.update(collectModel);
    }

    /**
     * 根据id删除客户信息（物理删除）
     * @param shop_collect_id
     * @return
     */
    @Override
    public int delById(Integer shop_collect_id) {
        return collectMapper.delById(shop_collect_id);
    }
}
