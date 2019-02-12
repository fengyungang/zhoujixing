package com.zhoujixing.dao;

import com.zhoujixing.entity.OrderModel;
import com.zhoujixing.entity.ShopsModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShopsMapper {
    /**
     * 添加方法
     * @param shopsModel
     * @return
     */
    int add(ShopsModel shopsModel);

    /**
     * 根据id查询一条信息
     * @param shop_shops_id
     * @return
     */
    ShopsModel getById(Integer shop_shops_id);

    /**
     * 查询所有信息
     * @param map
     * @return
     */
    List<ShopsModel> selA(Map<String, Object> map);
    /**
     * 根据id修改某条信息
     * @param shopsModel
     * @return
     */
    int update(ShopsModel shopsModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param shop_shops_id
     * @return
     */
    int delById(Integer shop_shops_id);

}
