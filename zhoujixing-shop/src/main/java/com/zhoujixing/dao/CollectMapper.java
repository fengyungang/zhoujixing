package com.zhoujixing.dao;


import com.zhoujixing.entity.CategoryModel;
import com.zhoujixing.entity.CollectModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CollectMapper {
    /**
     * 添加方法
     * @param collectModel
     * @return
     */
    int add(CollectModel collectModel);

    /**
     * 根据id查询一条信息
     * @param shop_collect_id
     * @return
     */
    CollectModel getById(Integer shop_collect_id);

    /**
     * 查询所有信息
     * @param map
     * @return
     */
    List<CollectModel> selA(Map<String, Object> map);
    /**
     * 根据id修改某条信息
     * @param collectModel
     * @return
     */
    int update(CollectModel collectModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param shop_collect_id
     * @return
     */
    int delById(Integer shop_collect_id);

}
