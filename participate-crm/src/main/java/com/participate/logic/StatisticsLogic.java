package com.participate.logic;

import com.alibaba.fastjson.JSONObject;
import com.participate.utils.DateUtils;
import com.participate.utils.Result;
import com.participate.utils.StatisticsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * 统计业务逻辑层
 */
@Component
public class StatisticsLogic {

    @Autowired
    private StatisticsUtils statisticsUtils;

    /**
     * 上周每天的评论及对应数量多条折线统计图
     * @return
     */
    public Result getLastWeekStackedLineChartByDayXNumYCodeL(){

        //上周一
        Date date = DateUtils.getBeginDayOfLastWeek();
        List<Date> dates = new ArrayList<>();
        //上周七天日期
        for (int i=0;i < 7;i++){
            dates.add(DateUtils.getPastDate(-i,date));
        }
        Map<String,Object> map = statisticsUtils.dayXNumYCodeL(dates);
        List<String> week = new ArrayList<>();
        week.add("周一");
        week.add("周二");
        week.add("周三");
        week.add("周四");
        week.add("周五");
        week.add("周六");
        week.add("周日");
        //替换x轴数据
        map.put("x",week);
        //转换格式输出
        JSONObject res =statisticsUtils.StackedLineChartByXYL("上周满意度测评","axis","3%","4%","3%",true,"category",false,"value","line","总量",map);
        return Result.generate(0,"success",res);
    }

    /**
     * 上周每天评论总数量，折线或曲线图
     * @param smooth
     * @return
     */
    public Result getLastWeekBasicOrSmoothedLineChartBydayXSumY(Boolean smooth){

        //为空时默认为false
        smooth = smooth==null?false:smooth;
        //上周一
        Date date = DateUtils.getBeginDayOfLastWeek();
        List<Date> dates = new ArrayList<>();
        //上周七天日期
        for (int i=0;i < 7;i++){
            dates.add(DateUtils.getPastDate(-i,date));
        }
        Map<String,Object> map = statisticsUtils.dayXSumY(dates);
        List<String> week = new ArrayList<>();
        week.add("周一");
        week.add("周二");
        week.add("周三");
        week.add("周四");
        week.add("周五");
        week.add("周六");
        week.add("周日");
        //替换x轴数据
        map.put("x",week);
        //转换格式输出
        JSONObject res = statisticsUtils.BasicOrSmoothedLineChartByXY("category","value","line",smooth,map);
        return Result.generate(0,"success",res);
    }

    /**
     * 前面七天每天的评论及对应数量多条折线统计图
     * @return
     */
    public Result getSevenDaysStackedLineChartByDayXNumYCodeL(){

        //获取前面七天每天日期
        List<Date> dates = new ArrayList<>();
        for (int i=7;i > 0;i--){
            dates.add(DateUtils.getPastDate(i,new Date()));
        }

        Map<String,Object> map = statisticsUtils.dayXNumYCodeL(dates);

        //转换格式输出
        JSONObject res =statisticsUtils.StackedLineChartByXYL("最近七天满意度测评","axis","3%","4%","3%",true,"category",false,"value","line","总量",map);
        return Result.generate(0,"success",res);
    }

    /**
     * 前面七天每天评论总数量，折线或曲线图
     * @param smooth
     * @return
     */
    public Result getSevenDaysBasicOrSmoothedLineChartBydayXSumY(Boolean smooth){

        //获取前面七天每天日期
        List<Date> dates = new ArrayList<>();
        for (int i=7;i > 0;i--){
            dates.add(DateUtils.getPastDate(i,new Date()));
        }

        Map<String,Object> map = statisticsUtils.dayXSumY(dates);

        //转换格式输出
        JSONObject res = statisticsUtils.BasicOrSmoothedLineChartByXY("category","value","line",smooth,map);
        return Result.generate(0,"success",res);
    }


    /**
     * 上个月每天的评论及对应数量多条折线统计图
     * @return
     */
    public Result getLastMonthStackedLineChartByDayXNumYCodeL(){

        //获取上个月首尾时间
        Map<String,Date> monthDate = DateUtils.getLastMonthDate();
        //根据首尾时间求一段时间
        List<Date> dates = DateUtils.getEveryDayByStartEnd(monthDate.get("start"),monthDate.get("end"));

        //查询数据
        Map<String,Object> map = statisticsUtils.dayXNumYCodeL(dates);

        //转换格式输出
        JSONObject res =statisticsUtils.StackedLineChartByXYL("上个月满意度测评","axis","3%","4%","3%",true,"category",false,"value","line","总量",map);
        return Result.generate(0,"success",res);
    }

    /**
     * 上个月每天评论总数量，折线或曲线图
     * @param smooth
     * @return
     */
    public Result getLastMonthBasicOrSmoothedLineChartBydayXSumY(Boolean smooth){

        //获取上个月首尾时间
        Map<String,Date> monthDate = DateUtils.getLastMonthDate();
        //根据首尾时间求一段时间
        List<Date> dates = DateUtils.getEveryDayByStartEnd(monthDate.get("start"),monthDate.get("end"));

        Map<String,Object> map = statisticsUtils.dayXSumY(dates);

        //转换格式输出
        JSONObject res = statisticsUtils.BasicOrSmoothedLineChartByXY("category","value","line",smooth,map);
        return Result.generate(0,"success",res);
    }

    /**
     * 昨天每小时的评论及对应数量多条折线统计图
     * @return
     */
    public Result getHourStackedLineChartByDayXNumYCodeL(String start,String end){

        //小时时间的存储
        List<Date> dates = new ArrayList<>();
        if (start!=null&&!"".equals(start)&&end!=null&&!"".equals(end)){
            //传入参数时，计算中间时间段
            dates = DateUtils.getEveryHourByStartEnd(DateUtils.StD(start,"yyyy-MM-dd-HH"),DateUtils.StD(start,"yyyy-MM-dd-HH"));

        }else {
            //默认为昨天0-23
           Date yesterday = DateUtils.getPastDate(1,new Date());
           dates = DateUtils.getEveryHourByStartEnd(DateUtils.getSomeDay0And23(yesterday).get("0"),DateUtils.getSomeDay0And23(yesterday).get("23"));
        }

        //查询数据
        Map<String,Object> map = statisticsUtils.hourXNumYCodel(dates);

        //转换格式输出
        JSONObject res =statisticsUtils.StackedLineChartByXYL("昨天满意度测评","axis","3%","4%","3%",true,"category",false,"value","line","总量",map);
        return Result.generate(0,"success",res);
    }

    /**
     *昨天每小时评论总数量，折线或曲线图
     * @param smooth
     * @return
     */
    public Result getHourBasicOrSmoothedLineChartBydayXSumY(Boolean smooth,String start,String end){

        //小时时间的存储
        List<Date> dates = new ArrayList<>();
        if (start!=null&&!"".equals(start)&&end!=null&&!"".equals(end)){
            //传入参数时，计算中间时间段
            dates = DateUtils.getEveryHourByStartEnd(DateUtils.StD(start,"yyyy-MM-dd-HH"),DateUtils.StD(start,"yyyy-MM-dd-HH"));

        }else {
            //默认为昨天0-23
            Date yesterday = DateUtils.getPastDate(1,new Date());
            dates = DateUtils.getEveryHourByStartEnd(DateUtils.getSomeDay0And23(yesterday).get("0"),DateUtils.getSomeDay0And23(yesterday).get("23"));
        }

        Map<String,Object> map = statisticsUtils.dayXSumY(dates);

        //转换格式输出
        JSONObject res = statisticsUtils.BasicOrSmoothedLineChartByXY("category","value","line",smooth,map);
        return Result.generate(0,"success",res);
    }

    /**
     * 获取一段时间内的各个评论的总数
     * @param smooth
     * @param start
     * @param end
     * @return
     */
    public Result getDayBasicOrSmoothedLineChartByCodeXSumY(Boolean smooth,String start,String end){
        //小时时间的存储
        List<Date> dates = new ArrayList<>();
        Date begin = null;
        Date finish = null;

        if (start!=null&&!"".equals(start)&&end!=null&&!"".equals(end)){
            //获取首尾时间
            begin = DateUtils.StD(start,"yyyy-MM-dd");
            finish = DateUtils.StD(end,"yyyy-MM-dd");

        }else {
            //默认获取上个月首尾时间
            Map<String,Date> monthDate = DateUtils.getLastMonthDate();
            begin = monthDate.get("start");
            finish = monthDate.get("end");
        }
        Map<String,Object> map = statisticsUtils.codeXSumY(begin,finish);

        //转换格式输出
        JSONObject res = statisticsUtils.BasicOrSmoothedLineChartByXY("category","value","line",smooth,map);

        return Result.generate(0,"success",res);
    }


}
