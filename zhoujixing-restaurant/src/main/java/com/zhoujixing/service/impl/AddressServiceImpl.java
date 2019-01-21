package com.zhoujixing.service.impl;

import com.zhoujixing.entity.Address;
import com.zhoujixing.mapper.AddressMapper;
import com.zhoujixing.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public boolean addAddress(Address address) {
        boolean result = false;
        if (addressMapper.insertAddress(address)>0){
            result = true;
        }
        return result;
    }

    @Override
    public Address getById(Integer id) {
        return addressMapper.selectById(id);
    }

    @Override
    public Address getByBuyerId(Integer buyerId) {
        return addressMapper.selectByBuyerId(buyerId);
    }

    @Override
    public Address getByStoreId(Integer storeId) {
        return addressMapper.selectByStoreId(storeId);
    }

    @Override
    public boolean modifyAddress(Address address) {
        boolean result = false;
        if (addressMapper.updateAddress(address)>0){
            result = true;
        }
        return result;
    }

    @Override
    public boolean removeAddress(Integer id) {
        boolean result = false;
        if (addressMapper.deleteAddress(id)>0){
            result = true;
        }
        return result;
    }
}
