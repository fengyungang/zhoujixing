package com.zhoujixing.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoujixing.dao.TakeMapper;
import com.zhoujixing.dao.UserinfoMapper;
import com.zhoujixing.entity.TakeModel;
import com.zhoujixing.entity.UserinfoModel;
import com.zhoujixing.service.TakeService;
import com.zhoujixing.service.UserinfoService;
import com.zhoujixing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    /**
     * 添加方法
     * @param userinfoModel
     * @return
     */
    @Override
    public int add(UserinfoModel userinfoModel) {
        return userinfoMapper.add(userinfoModel);
    }

    /**
     * 根据id查询一条信息
     * @param shop_userinfo_id
     * @return
     */
    @Override
    public UserinfoModel getById(Integer shop_userinfo_id) {
        return userinfoMapper.getById(shop_userinfo_id);
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
        List<UserinfoModel> userinfoModelList = userinfoMapper.selA(map);
        PageInfo<UserinfoModel> pageInfo = new PageInfo<>(page.getResult());
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();
        map.put("userinfoModelList",userinfoModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    @Override
    public List<UserinfoModel> selA(Map<String, Object> map) {
        return userinfoMapper.selA(map);
    }

    /**
     * 根据id修改某条信息
     * @param userinfoModel
     * @return
     */
    @Override
    public int update(UserinfoModel userinfoModel) {
        return userinfoMapper.update(userinfoModel);
    }

    /**
     * 根据id删除客户信息（物理删除）
     * @param shop_userinfo_id
     * @return
     */
    @Override
    public int delById(Integer shop_userinfo_id) {
        return userinfoMapper.delById(shop_userinfo_id);
    }
}