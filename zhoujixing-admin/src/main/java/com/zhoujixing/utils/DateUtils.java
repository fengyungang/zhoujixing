package com.zhoujixing.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间处理工具
 *        G 年代标志符
 *        y 年
 *        M 月
 *         d 日
 *        h 时 在上午或下午 (1~12)
 *        H 时 在一天中 (0~23)
 *        m 分
 *        s 秒
 *        S 毫秒
 *        E 星期
 *        D 一年中的第几天
 *        F 一月中第几个星期几
 *        w 一年中第几个星期
 *        W 一月中第几个星期
 *        a 上午 / 下午 标记符
 *        k 时 在一天中 (1~24)
 *        K 时 在上午或下午 (0~11)
 *        z 时区
 */
public class DateUtils {

    /**
     * 按照提供的格式将字符串转换成Date类型
     *
     * @param dateStr
     * @param formaterString
     * @return
     */
    public static Date StD(String dateStr, String formaterString) {
        Date date = null;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern(formaterString);
        try {
            date = formater.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 按照参数提供的格式将Date类型时间转换为字符串
     *
     * @param date
     * @param formaterString
     * @return
     */
    public static String DtS(Date date, String formaterString) {
        String time;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern(formaterString);
        time = formater.format(date);
        return time;
    }

    /**
     * date转换为unix时间
     * @param date
     * @return
     */
    public static Long Dtu(Date date){
        return date.getTime();
    }

    /**
     * unix时间转换为date
     * @param unixTime
     * @return
     */
    public static Date Utd(Long unixTime){
        return new Date(unixTime);
    }

    /**
     * 获取与现在的时间差
     * @param date
     * @return
     */

    public static Long timedifference(Date date){

        Date now = new Date();

        return (now.getTime()-date.getTime())/1000L;
    }
    /**
     * 根据时间获取星期几
     * @param date
     * @return
     */
    public static String getWeek(Date date){
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[w];
    }

    /**
     * 获取前边第past天的日期
     * @return
     */
    public static Date getPastDate(int past,Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        return calendar.getTime();
    }

    /**
     *  使用当前月份,得到上一个月的月份(第一天和最后一天)
     * @return
     * @throws ParseException
     */
    public static Map<String,Date> getLastMonthDate(){
        Map<String,Date> map = new HashMap<>();
        //获取上个月第一天
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        map.put("start",calendar.getTime());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 1);
        calendar2.add(Calendar.DATE, -1);
        map.put("end",calendar2.getTime());
        return map;
    }

    // 获取上周的开始时间
    @SuppressWarnings("unused")
    public static Date getBeginDayOfLastWeek() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek - 7);
        return getDayStartTime(cal.getTime());
    }


    // 获取某个日期的开始时间
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d)
            calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取时间段
     * @param start
     * @param end
     * @return
     */
    public static List<Date> getEveryDayByStartEnd(Date start, Date end) {

        List<Date> dates = new ArrayList<>();
        Date flag = start;
        while (!DtS(flag, "yyyy-MM-dd").equals(DtS(end, "yyyy-MM-dd"))) {
            dates.add(flag);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(flag);
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 1);
            flag = calendar.getTime();
        }
        dates.add(flag);
        return  dates;
    }

    /**
     * 获取小时段
     * @param start
     * @param end
     * @return
     */
    public static List<Date> getEveryHourByStartEnd(Date start,Date end) {

        List<Date> dates = new ArrayList<>();
        Date flag = start;
        while (!DtS(flag, "yyyy-MM-dd-HH").equals(DtS(end, "yyyy-MM-dd-HH"))) {
            dates.add(flag);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(flag);
            calendar.add(Calendar.HOUR,1);
            flag = calendar.getTime();
            System.out.println(DtS(flag,"yyyy-MM-dd-HH"));
        }
        dates.add(flag);
        return  dates;
    }

    /**
     * 获取某一天0点23点的日期
     * @param date
     * @return
     */
    public static Map<String,Date> getSomeDay0And23(Date date){
        Map<String,Date> map = new HashMap<>();
        //获取0点
        Date start = StD((DtS(date,"yyyy-MM-dd")+"-00"),"yyyy-MM-dd-HH");
        //获取23点
        Date end = StD((DtS(date,"yyyy-MM-dd")+"-23"),"yyyy-MM-dd-HH");

        map.put("0",start);
        map.put("23",end);
        return map;
    }

}
