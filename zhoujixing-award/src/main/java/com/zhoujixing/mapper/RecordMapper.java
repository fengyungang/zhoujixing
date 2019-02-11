package com.zhoujixing.mapper;

import com.zhoujixing.entity.Record;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecordMapper {

    /**
     * 插入中奖信息
     * @param record
     * @return
     */
    int insertRecord(Record record);


}
