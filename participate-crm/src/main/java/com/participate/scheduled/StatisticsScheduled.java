package com.participate.scheduled;

import com.participate.logic.DateStatisticsLogic;
import com.participate.logic.TimeStatisticsLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 满意度任务调度
 * 定时任务
 */
@Component
public class StatisticsScheduled {

    @Autowired
    private DateStatisticsLogic dateStatisticsLogic;
    @Autowired
    private TimeStatisticsLogic timeStatisticsLogic;

    /**
     * 每天1点定时统计数据
     */
    //定时注解
    @Scheduled(cron = "0 0 1 * * ? ")
    public void daily(){
        //新线程
        new Thread() {
            public void run() {
                //执行任务
                dateStatisticsLogic.statistics();
            }
        }.start();

    }

    /**
     * 每个整点准时统计数据
     */
    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void hourly(){
        new Thread() {
            public void run() {
                timeStatisticsLogic.statistics();
            }
        }.start();

    }
}
