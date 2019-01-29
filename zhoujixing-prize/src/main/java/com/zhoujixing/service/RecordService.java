package com.zhoujixing.service;

import com.zhoujixing.entity.Record;

public interface RecordService {
    /**
     * 添加中奖信息
     * @param record
     * @return
     */
    boolean addRecord(Record record);
}
