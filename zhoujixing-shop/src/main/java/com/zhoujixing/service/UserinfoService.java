package com.zhoujixing.service;

import com.zhoujixing.entity.ShopsModel;
import com.zhoujixing.entity.TakeModel;
import com.zhoujixing.entity.UserinfoModel;

import java.util.List;
import java.util.Map;

public interface UserinfoService {
    /**
     * 添加方法
     * @param userinfoModel
     * @return
     */
    int add(UserinfoModel userinfoModel);

    /**
     * 根据id查询一条信息
     * @param shop_userinfo_id
     * @return
     */
    UserinfoModel getById(Integer shop_userinfo_id);

    /**
     * 查询所有信息
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Map<String,Object> selA(Map<String, Object> map, Integer pageIndex, Integer pageSize);

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    List<UserinfoModel> selA(Map<String, Object> map);

    /**
     * 根据id修改某条信息
     * @param userinfoModel
     * @return
     */
    int update(UserinfoModel userinfoModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param shop_userinfo_id
     * @return
     */
    int delById(Integer shop_userinfo_id);

}
