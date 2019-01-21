package com.zhoujixing.service;

import com.zhoujixing.entity.Store;

import java.util.List;

public interface StoreService {

    /**
     * 添加店铺信息
     * @param store
     * @return
     */
    boolean  addStore(Store store);

    /**
     * 查询所有店铺信息
     * @return
     */
    List<Store> getAllStore();

    /**
     * 根据id查询店铺信息
     * @param id
     * @return
     */
    Store getById(Integer id);

    /**
     * 修改店铺信息
     * @param store
     * @return
     */
    boolean updateStore(Store store);

    /**
     * 根据id删除店铺信息
     * @param id
     * @return
     */
    boolean removeStore(Integer id);

}
