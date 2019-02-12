package com.zhoujixing.mapper;

import com.zhoujixing.entity.SysCityEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityMapper {

    /**
     * 获得全国省的方法
     * @return
     */
    List<SysCityEntity> getCityList();

    /**
     * 获得市 县 区 的方法
     * @param parentId
     * @return
     */
    List<SysCityEntity> getCity(String parentId);

    /**
     * 返回所有城市的集合
     * @return
     */
    List<SysCityEntity> getAllCityList();
}
