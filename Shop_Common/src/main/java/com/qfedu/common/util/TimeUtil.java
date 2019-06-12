package com.qfedu.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
    //  获取时间字符串
    public static String getTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        return format;
    }

    /**
     *  计算N天之后的时间
     * @param days
     *         N天
     * @return
     */
    public static Date getDays(int days){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,days);
        return calendar.getTime();
    }

    /**
     *  计算N月之后的时间
     * @param months
     *          N月
     * @return
     */
    public static Date getMonths(int months){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,months);
        return calendar.getTime();
    }
}
