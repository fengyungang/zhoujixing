package com.zhoujixing.service.impl;

import com.zhoujixing.entity.Store;
import com.zhoujixing.mapper.StoreMapper;
import com.zhoujixing.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("storeService")
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public boolean addStore(Store store) {
        boolean result = false;
        if (storeMapper.insertStore(store)>0){
            result = true;
        }
        return result;
    }

    @Override
    public List<Store> getAllStore() {
        return storeMapper.selectAllStore();
    }

    @Override
    public Store getById(Integer id) {
        return storeMapper.selectById(id);
    }

    @Override
    public boolean updateStore(Store store) {
        boolean result = false;
        if (storeMapper.updateStore(store)>0){
            result = true;
        }
        return result;
    }

    @Override
    public boolean removeStore(Integer id) {
        boolean result = false;
        if (storeMapper.deleteStore(id)>0){
            result = true;
        }
        return result;
    }
}
