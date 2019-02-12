package com.zhoujixing.service;

import com.zhoujixing.entity.SysCityEntity;

import java.util.List;

public interface SysCityService {
    /**
     * 查找所有省的方法
     *
     * @return
     */
    List<SysCityEntity> getCityList();

    /**
     * 获得市县区的方法
     * @param parentId
     * @return
     */
    List<SysCityEntity> SysCityEntity(String parentId);

    /**
     * 获得所有城市的列表
     * @return
     */
    List<SysCityEntity> getAllCityList();
}
