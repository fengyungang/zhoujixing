package com.participate.logic;

import com.participate.entity.DateStatisticsModel;
import com.participate.service.CustomerService;
import com.participate.service.DateStatisticsService;
import com.participate.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 按日期统计业务逻辑层
 */
@Component
public class DateStatisticsLogic {
    @Autowired
    private DateStatisticsService dateStatisticsService;
    @Autowired
    private CustomerService customerService;

    /**
     * 查询并保存统计
     */
    public void statistics(){
        //获取前一天
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天
        Date date = calendar.getTime();
        System.out.println(date.toString());
        //获取统计数据
        List<DateStatisticsModel> dateStatisticsModelList = customerService.getDayCOUNT(date);
        for (Iterator<DateStatisticsModel> iterator = dateStatisticsModelList.iterator(); iterator.hasNext(); ) {
            DateStatisticsModel next =  iterator.next();
            dateStatisticsService.add(next);
        }
    }
}

