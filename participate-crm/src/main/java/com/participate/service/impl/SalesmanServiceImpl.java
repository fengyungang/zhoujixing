package com.participate.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.participate.dao.SalesmanMapper;
import com.participate.entity.SalesmanModel;
import com.participate.service.SalesmanService;
import com.participate.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SalesmanServiceImpl implements SalesmanService {
    @Autowired
    private SalesmanMapper salesmanMapper;

    /**
     * 添加方法
     * @param salesmanModel
     * @return
     */
    @Override
    public int add(SalesmanModel salesmanModel) {
        return salesmanMapper.add(salesmanModel);
    }

    /**
     * 根据id查询一条信息
     * @param salesman_id
     * @return
     */
    @Override
    public SalesmanModel getById(Integer salesman_id) {
        return salesmanMapper.getById(salesman_id);
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

        PageHelper.startPage(pageIndex,pageSize);
        List<SalesmanModel> salesmanModelList = salesmanMapper.selA(map);
        PageInfo<SalesmanModel> pageInfo = new PageInfo<>();
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();
        map.put("salesmanModelList",salesmanModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    public List<SalesmanModel> selA(Map<String, Object> map){
        return salesmanMapper.selA(map);
    }

    /**
     * 根据id修改某条信息
     * @param salesmanModel
     * @return
     */
    @Override
    public int update(SalesmanModel salesmanModel) {
        return salesmanMapper.update(salesmanModel);
    }

    /**
     * 根据id删除销售人员信息（物理删除）
     * @param salesman_id
     * @return
     */
    @Override
    public int delById(Integer salesman_id) {
        return salesmanMapper.delById(salesman_id);
    }
}
