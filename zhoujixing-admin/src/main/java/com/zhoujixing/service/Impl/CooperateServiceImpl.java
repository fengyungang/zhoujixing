package com.zhoujixing.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoujixing.entity.CooperateEntity;
import com.zhoujixing.entity.SysCityEntity;
import com.zhoujixing.mapper.CityMapper;
import com.zhoujixing.mapper.CooperateMapper;
import com.zhoujixing.service.CooperateService;
import com.zhoujixing.service.SysCityService;
import com.zhoujixing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CooperateServiceImpl implements CooperateService {

    @Autowired
    private CooperateMapper cooperateMapper;

    /**
     * 添加方法
     * @param cooperateEntity
     * @return
     */
    @Override
    public int add(CooperateEntity cooperateEntity) {
        cooperateEntity.setCooperate_state(0);
        cooperateEntity.setCooperate_create_time(new Date());
        return cooperateMapper.add(cooperateEntity);
    }

    /**
     * 根据id查询一条信息
     * @param cooperate_id
     * @return
     */
    @Override
    public CooperateEntity getById(Integer cooperate_id) {
        return cooperateMapper.getById(cooperate_id);
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
        List<CooperateEntity> callLogModelList = cooperateMapper.selA(map);
        PageInfo<CooperateEntity> pageInfo = new PageInfo<>();
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();

        map.put("callLogModelList",callLogModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 根据id修改某条信息
     * @param cooperateEntity
     * @return
     */
    @Override
    public int update(CooperateEntity cooperateEntity) {
        return cooperateMapper.update(cooperateEntity);
    }

    /**
     * 根据id删除一条信息
     * @param cooperate_id
     * @return
     */
    @Override
    public int delById(Integer cooperate_id) {
        return cooperateMapper.delById(cooperate_id);
    }



}
