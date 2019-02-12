package com.zhoujixing.dao;

import com.zhoujixing.entity.TakeModel;
import com.zhoujixing.entity.UserinfoModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserinfoMapper {
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
