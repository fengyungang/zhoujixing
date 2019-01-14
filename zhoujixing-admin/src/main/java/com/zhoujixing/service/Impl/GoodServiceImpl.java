package com.zhoujixing.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoujixing.entity.CommentEntity;
import com.zhoujixing.entity.GoodEntity;
import com.zhoujixing.mapper.CommentMapper;
import com.zhoujixing.mapper.GoodMapper;
import com.zhoujixing.service.CommentService;
import com.zhoujixing.service.GoodService;
import com.zhoujixing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    /**
     * 添加方法
     * @param goodEntity
     * @return
     */
    @Override
    public int add(GoodEntity goodEntity) {
        goodEntity.setGood_create_time(new Date());
        return goodMapper.add(goodEntity);
    }

    /**
     * 根据id查询一条信息
     * @param good_id
     * @return
     */
    @Override
    public GoodEntity getById(Integer good_id) {
        return goodMapper.getById(good_id);
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
        List<GoodEntity> goodEntityList = goodMapper.selA(map);
        PageInfo<GoodEntity> pageInfo = new PageInfo<>();
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();

        map.put("goodEntityList",goodEntityList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 根据id删除一条信息（物理删除）
     * @param good_id
     * @return
     */
    @Override
    public int delById(Integer good_id) {
        return goodMapper.delById(good_id);
    }

    /**
     * 根据条件查询点赞列表
     * @param map
     * @return
     */
    @Override
    public List<GoodEntity> getList(Map<String, Object> map) {
        List<GoodEntity> goodEntityList = goodMapper.selA(map);
        return goodEntityList;
    }
}
