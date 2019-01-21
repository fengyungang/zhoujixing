package com.zhoujixing.service;

import com.zhoujixing.entity.Address;

public interface AddressService {

    /**
     * 添加地址
     * @param address
     * @return
     */
    boolean addAddress(Address address);

    /**
     * 根据id查询地址信息
     * @param id
     * @return
     */
    Address getById(Integer id);

    /**
     * 根据订单编号查询地址信息
     * @param buyerId
     * @return
     */
    Address getByBuyerId(Integer buyerId);

    /**
     * 根据店铺id查询地址信息
     * @param storeId
     * @return
     */
    Address getByStoreId(Integer storeId);

    /**
     * 修改地址信息
     * @param address
     * @return
     */
    boolean modifyAddress(Address address);

    /**
     * 根据id删除地址信息
     * @param id
     * @return
     */
    boolean removeAddress(Integer id);

}
