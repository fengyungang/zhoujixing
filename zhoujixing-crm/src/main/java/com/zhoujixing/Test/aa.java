package com.zhoujixing.Test;

import com.zhoujixing.utils.DateUtils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class aa {

    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d)
            calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

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


    public static void main(String[] args) {
        Date yesterday = DateUtils.getPastDate(1,new Date());
        List<Date> dates =  DateUtils.getEveryHourByStartEnd(DateUtils.getSomeDay0And23(yesterday).get("0"),DateUtils.getSomeDay0And23(yesterday).get("23"));
        for (Iterator<Date> iterator = dates.iterator(); iterator.hasNext(); ) {
            Date next =  iterator.next();
            System.out.println(next.toString());
        }
    }
}

