package com.zhoujixing.service.impl;

import com.zhoujixing.entity.Record;
import com.zhoujixing.mapper.RecordMapper;
import com.zhoujixing.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public boolean addRecord(Record record) {
        boolean result = false;
        if(recordMapper.insertRecord(record)>0){
            result = true;
        }
        return result;
    }
}
