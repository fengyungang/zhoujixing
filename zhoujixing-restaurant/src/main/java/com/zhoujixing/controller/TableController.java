package com.zhoujixing.controller;

import com.zhoujixing.entity.Table;
import com.zhoujixing.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/table")
public class TableController {

    @Autowired
    private TableService tableService;

    @RequestMapping("/addtable")
    public Map<Object,String> addTable(Integer buyerId,Integer capacity,String depict,Integer tableStatus){
        Map<Object,String> modelMap = new HashMap<>();
        Table table1 = tableService.getByBuyerId(buyerId);
        if (table1 == null){
            Table table = new Table();
            table.setBuyerId(buyerId);
            table.setCapacity(capacity);
            table.setDepict(depict);
            table.setTableStatus(tableStatus);
            tableService.addTable(table);
            modelMap.put(1,"添加成功！");
        }else {
            modelMap.put(0,"该餐桌已占用！");
        }
        return modelMap;
    }

    @RequestMapping("/getalltable")
     public Map<String,Object> getAllTable(){
        Map<String,Object> modelMap = new HashMap<>();
        List<Table> list = tableService.getAllTable();
        modelMap.put("tables",list);
        return modelMap;
     }

    @RequestMapping("/getbytablestatus")
     public Map<String,Object> getByTableStatus(Integer tableStatus){
        Map<String,Object> modelMap = new HashMap<>();
        List<Table> list = tableService.getByTableStatus(tableStatus);
        if (tableStatus == 1){
            modelMap.put("使用中",list);
        }else {
            modelMap.put("空闲中",list);
        }
        return modelMap;
     }

    @RequestMapping("/modifytable")
    public Map<Object,String> modifyTable(Integer id,Integer buyerId,Integer capacity,String depict,Integer tableStatus){
        Map<Object,String> modelMap = new HashMap<>();
        Table table = tableService.getById(id);
        if (table != null){
            table.setBuyerId(buyerId);
            table.setCapacity(capacity);
            table.setDepict(depict);
            table.setTableStatus(tableStatus);
            tableService.modifyTable(table);
            modelMap.put(1,"餐桌信息修改成功！");
        }else {
            modelMap.put(0,"餐桌号不存在！");
        }
        return modelMap;
    }

    @RequestMapping("/removetable")
    public Map<Object,String> removeTable(Integer id){
        Map<Object,String> modelMap = new HashMap<>();
        if (tableService.removeTable(id)){
            modelMap.put(1,"删除成功！");
        }else {
            modelMap.put(0,"餐桌号不存在！");
        }
        return modelMap;
    }

}
