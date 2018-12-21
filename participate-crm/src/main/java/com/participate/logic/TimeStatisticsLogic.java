package com.participate.logic;

import com.participate.entity.DateStatisticsModel;
import com.participate.entity.TimeStatisticsModel;
import com.participate.service.CustomerService;
import com.participate.service.DateStatisticsService;
import com.participate.service.TimeStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 按时间统计业务逻辑层
 */
@Component
public class TimeStatisticsLogic {

    @Autowired
    private TimeStatisticsService timeStatisticsService;
    @Autowired
    private CustomerService customerService;

    /**
     * 查询并保存统计
     */
    public void statistics() {

        //获取前小时
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, -1); //得到前一小时
        Date date = calendar.getTime();
        System.out.println(date.toString());
        //获取统计数据
        List<TimeStatisticsModel> timeStatisticsModelList = customerService.getHourCOUNT(date);
        for (Iterator<TimeStatisticsModel> iterator = timeStatisticsModelList.iterator(); iterator.hasNext(); ) {
            TimeStatisticsModel next = iterator.next();
            timeStatisticsService.add(next);
        }

    }
}

