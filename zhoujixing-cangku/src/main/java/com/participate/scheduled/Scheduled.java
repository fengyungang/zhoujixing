package com.participate.scheduled;


import com.participate.entity.ChuruEntity;

import com.participate.mapper.WuPinMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 满意度任务调度
 * 定时任务
 */
@Component
class StatisticsScheduled {

    @Autowired
    WuPinMapper wuPinMapper;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    /**
     * 每天1点定时统计数据
     */
    //定时注解
    @Scheduled(cron = "0 0/1 0 * * ?")
    public void daily(){
        //新线程
        new Thread() {
            public void run() {
                //执行任务
                List<ChuruEntity> churuEntities=wuPinMapper.banxiaoshi();

            }
        }.start();

    }
    @Scheduled(fixedRate = 2000)
    public void testTasks() {
        wuPinMapper.banxiaoshi();

    }
//    /**
//     * 每个整点准时统计数据
//     */
//    @Scheduled(cron = "0 0 0/1 * * ? ")
//    public void hourly(){
//        new Thread() {
//            public void run() {
//
//                timeStatisticsLogic.statistics();
//            }
//        }.start();
//
//    }
}
