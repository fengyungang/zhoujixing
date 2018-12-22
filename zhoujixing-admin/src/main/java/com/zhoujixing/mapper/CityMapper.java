package com.zhoujixing.mapper;

import com.zhoujixing.entity.SysCityEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface CityMapper {

    /**
     * 省 市 县 区  查找方法
     * @param cityEntity
     * @return
     */
    List<SysCityEntity> cityList(SysCityEntity cityEntity);
}
