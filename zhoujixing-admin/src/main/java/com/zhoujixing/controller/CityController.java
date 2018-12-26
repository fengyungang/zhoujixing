package com.zhoujixing.controller;

import com.zhoujixing.entity.SysCityEntity;
import com.zhoujixing.service.SysCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CityController {

    @Autowired
    private SysCityService sysCityService;

    @ResponseBody
    @RequestMapping("/getCity")
    public List<SysCityEntity> getCity(SysCityEntity sysCityEntity){
        List<SysCityEntity> list = sysCityService.getCityList(sysCityEntity);
        return list;
    }
}
