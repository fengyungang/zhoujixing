package com.zhoujixing.api;

import com.sun.org.apache.regexp.internal.RE;
import com.zhoujixing.conf.datasources.DataSourceNames;
import com.zhoujixing.conf.datasources.annotation.DataSource;

import com.zhoujixing.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@RequestMapping("demo")
public class DemoApi extends BaseApi{



    @DataSource(name = DataSourceNames.FIRST)
    @RequestMapping("d1")
    public Result getD1(){

        return Result.generate(0,"success",null);
    }
    @DataSource(name = DataSourceNames.SECOND)
    @RequestMapping("d2")
    public Result getD2(){

        return Result.generate(0,"success",null);



    }
}
