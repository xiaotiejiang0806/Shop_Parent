package com.qfedu.common.util;

import java.text.ParseException;
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

    //  获取当前日期字符串
    public static String getDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        return format;
    }

    //  获取日期字符串
    public static String getFormatDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }

    /**
     *  计算N年之后的时间
     * @param year
     *          N年
     * @return
     */
    public static Date getYears(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR,year);
        return calendar.getTime();
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


    /**
     *  N分钟后
     * @param min
     * @return
     */
    public static Date getMin(int min){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,min);
        return calendar.getTime();
    }

    /**
     *  获取当日剩余的时间
     * @return
     */
    public static int getLastSecond(){
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date lastDate = simpleDateFormat.parse(getDate() + " 23:59:29");
            return (int)((lastDate.getTime()-currentDate.getTime())/1000);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     *  获取当前天数和指定天数的距离天数
     * @param date
     * @return
     */
    public static int getDistanceDays(Date date){
        Calendar instance = Calendar.getInstance();
        long l = instance.getTime().getTime() / 1000 / 24 / 3600 - date.getTime() / 1000 / 24 / 3600;
        return (int) l;

    }

  /*  public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DAY_OF_MONTH ,-5);
        System.out.println(getDistanceDays(instance.getTime()));
    }*/
}
