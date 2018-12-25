package com.zhoujixing.mapper;

import com.zhoujixing.entity.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {
    /**
     * 添加地址
     * @param address
     * @return
     */
    int insertAddress(Address address);

    /**
     * 根据id查询地址信息
     * @param id
     * @return
     */
    Address selectById(Integer id);

    /**
     * 根据订单编号查询地址信息
     * @param buyerId
     * @return
     */
    Address selectByBuyerId(Integer buyerId);

    /**
     * 根据店铺id查询地址信息
     * @param storeId
     * @return
     */
    Address selectByStoreId(Integer storeId);

    /**
     * 修改地址信息
     * @param address
     * @return
     */
    int updateAddress(Address address);

    /**
     * 根据id删除地址信息
     * @param id
     * @return
     */
    int deleteAddress(Integer id);
}
