package com.zhoujixing.service.impl;

import com.zhoujixing.entity.Table;
import com.zhoujixing.mapper.TableMapper;
import com.zhoujixing.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tableService")
public class TableServiceImpl implements TableService {

    @Autowired
    private TableMapper tableMapper;

    @Override
    public boolean addTable(Table table) {
        boolean result = false;
        if (tableMapper.insertTable(table)>0){
            result = true;
        }
        return result;
    }

    @Override
    public List<Table> getAllTable() {
        return tableMapper.selectAllTable();
    }

    @Override
    public List<Table> getByTableStatus(Integer tableStatus) {
        return tableMapper.selectByTableStatus(tableStatus);
    }

    @Override
    public Table getByBuyerId(Integer buyerId) {
        return tableMapper.selectByBuyerId(buyerId);
    }

    @Override
    public Table getById(Integer id) {
        return tableMapper.selectById(id);
    }

    @Override
    public boolean modifyTable(Table table) {
        boolean result = false;
        if (tableMapper.updateTable(table)>0){
            result = true;
        }
        return result;
    }

    @Override
    public boolean removeTable(Integer id) {
        boolean result = false;
        if (tableMapper.deleteTable(id)>0){
            result = true;
        }
        return result;
    }
}
