package com.pp.common.utils.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author scott
 * @date 2019/6/20 - 14:15
 */
public class TimeUtils {
    private TimeUtils() {
        throw new IllegalStateException("Utility class");
    }


    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_DATE_TIME = "yyyy-MM-dd hh:mm:ss";
    public static final String FORMAT_MONTH_DAY_TIME = "MM月dd日 hh:mm";
    private static final int YEAR = 365 * 24 * 60 * 60;// 年
    private static final int MONTH = 30 * 24 * 60 * 60;// 月
    private static final int DAY = 24 * 60 * 60;// 天
    private static final int HOUR = 60 * 60;// 小时
    private static final int MINUTE = 60;// 分钟

    /**
     * 根据时间戳获取描述性时间，如3分钟前，1天前
     *
     * @param timestamp 时间戳 单位为毫秒
     * @return 时间字符串
     */
    public static String getDescriptionTimeFromTimestamp(long timestamp) {
        long currentTime = System.currentTimeMillis();
        long timeGap = (currentTime - timestamp) / 1000;// 与现在时间相差秒数
        String timeStr;
        if (timeGap > YEAR) {
            timeStr = timeGap / YEAR + "年前";
        } else if (timeGap > MONTH) {
            timeStr = timeGap / MONTH + "个月前";
        } else if (timeGap > DAY) {// 1天以上
            timeStr = timeGap / DAY + "天前";
        } else if (timeGap > HOUR) {// 1小时-24小时
            timeStr = timeGap / HOUR + "小时前";
        } else if (timeGap > MINUTE) {// 1分钟-59分钟
            timeStr = timeGap / MINUTE + "分钟前";
        } else {// 1秒钟-59秒钟
            timeStr = "刚刚";
        }
        return timeStr;
    }

    /**
     * 根据时间戳获取指定格式的时间，如2011-11-30 08:40
     *
     * @param timestamp 时间戳 单位为毫秒
     * @param format    指定格式 如果为null或空串则使用默认格式"yyyy-MM-dd hh:mm:ss"
     * @return
     */
    public static String getFormatTimeFromTimestamp(long timestamp, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        if (format == null || "".equals(format.trim())) {
            simpleDateFormat.applyPattern(FORMAT_DATE);
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            int year = Integer.parseInt(simpleDateFormat.format(new Date(timestamp))
                    .substring(0, 4));
            if (currentYear == year) {//如果为今年则不显示年份
                simpleDateFormat.applyPattern(FORMAT_MONTH_DAY_TIME);
            } else {
                simpleDateFormat.applyPattern(FORMAT_DATE_TIME);
            }
        } else {
            simpleDateFormat.applyPattern(format);
        }
        Date date = new Date(timestamp);
        return simpleDateFormat.format(date);
    }


    /**
     * 根据时间戳获取指定格式的时间，如2011-11-30 08:40
     *
     * @param timestamp 时间戳 单位为毫秒
     * @return
     */
    public static String getFormatTimeFromTimestamp(long timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(FORMAT_DATE);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int year = Integer.parseInt(simpleDateFormat.format(new Date(timestamp))
                .substring(0, 4));
        if (currentYear == year) {//如果为今年则不显示年份
            simpleDateFormat.applyPattern(FORMAT_MONTH_DAY_TIME);
        } else {
            simpleDateFormat.applyPattern(FORMAT_DATE_TIME);
        }
        Date date = new Date(timestamp);
        return simpleDateFormat.format(date);
    }


    /**
     * 获取当前日期的指定格式的字符串
     *
     * @param format 指定的日期时间格式，若为null或""则使用指定的格式"yyyy-MM-dd HH:MM"
     * @return
     */
    public static String getCurrentTime(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        if (format == null || "".equals(format.trim())) {
            simpleDateFormat.applyPattern(FORMAT_DATE_TIME);
        } else {
            simpleDateFormat.applyPattern(format);
        }
        return simpleDateFormat.format(new Date());
    }

    /**
     * 获取当前日期的指定格式的字符串
     *
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(FORMAT_DATE_TIME);
        return simpleDateFormat.format(new Date());
    }


    /**
     * 将日期字符串以指定格式转换为Date
     *
     * @param timeStr 日期字符串
     * @param format  指定的日期格式，若为null或""则使用指定的格式"yyyy-MM-dd hh:mm:ss"
     * @return
     */
    public static Date getTimeFromString(String timeStr, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        if (format == null || "".equals(format.trim())) {
            simpleDateFormat.applyPattern(FORMAT_DATE_TIME);
        } else {
            simpleDateFormat.applyPattern(format);
        }
        try {
            return simpleDateFormat.parse(timeStr);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * 将日期字符串以指定格式转换为Date
     *
     * @param timeStr 日期字符串
     * @return
     */
    public static Date getTimeFromString(String timeStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(FORMAT_DATE_TIME);
        try {
            return simpleDateFormat.parse(timeStr);
        } catch (ParseException e) {
            return new Date();
        }
    }


    /**
     * 将Date以指定格式转换为日期时间字符串
     *
     * @param time   日期
     * @param format 指定的日期时间格式，若为null或""则使用指定的格式"yyyy-MM-dd HH:MM"
     * @return
     */
    public static String getStringFromTime(Date time, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        if (format == null || "".equals(format.trim())) {
            simpleDateFormat.applyPattern(FORMAT_DATE_TIME);
        } else {
            simpleDateFormat.applyPattern(format);
        }
        return simpleDateFormat.format(time);
    }

    /**
     * 将Date以指定格式转换为日期时间字符串
     *
     * @param time   日期
     * @return
     */
    public static String getStringFromTime(Date time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(FORMAT_DATE_TIME);
        return simpleDateFormat.format(time);
    }

    /**
     * 获取时间1比时间2多的分钟数
     * @param time1 时间1
     * @param time2 时间2
     * @return      相差的分钟数
     */
    public static Integer time1SubtractTime2(Date time1, Date time2) {
        long time = time1.getTime() - time2.getTime();
        return (int) time / 1000 / 60;
    }

    public static Date getBeforeDayTime(int day) {
        Calendar dar = Calendar.getInstance();
        dar.setTime(new Date());
        dar.add(Calendar.HOUR_OF_DAY, day);
        return dar.getTime();
    }
}
