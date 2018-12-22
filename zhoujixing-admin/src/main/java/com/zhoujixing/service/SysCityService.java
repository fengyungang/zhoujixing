package com.zhoujixing.service;

import com.zhoujixing.entity.SysCityEntity;

import java.util.List;

public interface SysCityService {
    /**
     * 省 市 县 区  查找方法
     * @param cityEntity
     * @return
     */
    List<SysCityEntity> cityList(SysCityEntity cityEntity);
}
