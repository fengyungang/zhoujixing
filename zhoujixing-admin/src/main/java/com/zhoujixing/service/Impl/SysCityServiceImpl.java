package com.zhoujixing.service.Impl;

import com.zhoujixing.entity.SysCityEntity;
import com.zhoujixing.mapper.CityMapper;
import com.zhoujixing.service.SysCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysCityServiceImpl implements SysCityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<SysCityEntity> cityList(SysCityEntity cityEntity) {
        return null;
    }
}
