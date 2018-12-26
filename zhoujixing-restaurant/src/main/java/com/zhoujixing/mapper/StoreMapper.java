package com.zhoujixing.mapper;


import com.zhoujixing.entity.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {

    /**
     * 添加店铺信息
     * @param store
     * @return
     */
    int insertStore(Store store);

    /**
     * 查询所有店铺信息
     * @return
     */
    List<Store> selectAllStore();

    /**
     * 根据id查询店铺信息
     * @param id
     * @return
     */
    Store selectById(Integer id);

    /**
     * 修改店铺信息
     * @param store
     * @return
     */
    int updateStore(Store store);

    /**
     * 根据id删除店铺信息
     * @param id
     * @return
     */
    int deleteStore(Integer id);
}
