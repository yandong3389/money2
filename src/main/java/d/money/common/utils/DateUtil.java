package d.money.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import d.money.common.exception.SystemException;

/**
 * 类名称：DateUtil 内容摘要：处理日期的工具类
 * @version 1.0 2011-7-6
 */
public class DateUtil {

    /** 格式化日期对象 */
    private static SimpleDateFormat format = new SimpleDateFormat();

    /** 日期格式【yyyyMMddHHmmssSSS】 */
    public static String PATTERN_YYYY_MM_DD_HH_mm_ss_SSS = "yyyyMMddHHmmssSSS";

    /** 日期格式【yyMMdd】 */
    public static String PATTERN_YY_MM_DD = "yyMMdd";

    /**
     * 日期格式： yyyy
     */
    public static final String DATE_FMT_YYYY = "yyyy";

    /**
     * 日期格式： MM
     */
    public static final String DATE_FMT_MM = "MM";

    /**
     * 日期格式： yyyyMM
     */
    public static final String DATE_FMT_YYYYMM_NS = "yyyyMM";

    /**
     * 日期格式： yyyy/MM/dd
     */
    public static final String DATE_FMT_YYYYMMDD = "yyyy/MM/dd";

    /**
     * 日期格式： yyyyMMdd
     */
    public static final String DATE_FMT_YYYYMMDD_NS = "yyyyMMdd";

    /**
     * 日期格式： yyyy/MM/dd HH:mm:ss
     */
    public static final String DATE_FMT_YYYYMMDDHHMMSS = "yyyy/MM/dd HH:mm:ss";

    /**
     * 日期格式：yyyy-MM-dd
     */
    public static final String DATE_FMT_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 日期格式：yyyy年MM月dd日
     */
    public static final String DATE_FMT_YYYY_MM_DD2 = "yyyy年MM月dd日";

    /**
     * 取得日期字符串
     * @param date 日期
     * @param pattern 日期格式
     * @return String 日期字符串
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        format.applyPattern(pattern);
        return format.format(date);
    }

    /**
     * 向前或是向后滚动年
     * @param Date date
     * @param int rollCount
     * @return Date 日期
     */
    public static Date rollYear(Date date, int rollCount) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.roll(Calendar.YEAR, rollCount);
        return ca.getTime();
    }

    /**
     * 向前或者向后滚动月份 正数像前滚 负数向后滚
     * @param date 准备滚动的日期
     * @param rollCount 滚动参数
     * @return Date 滚动之后的日期
     */
    public static Date rollMonth(Date date, int rollCount) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MONTH, rollCount);
        return ca.getTime();
    }

    /**
     * 时间滚动 正数像前滚 负数向后滚
     * @param date 准备滚动的日期
     * @param calendar 滚动系数
     *            年 Calendar.YEAR;
     *            月 Calendar.MONTH;
     *            日 Calendar.DATE;
     *            时 Calendar.HOUR;
     *            钟Calendar.MINUTE;
     * @param rollCount 滚动参数
     * @return Date 滚动之后的日期
     */
    public static Date rollDate(Date date, int calendar, int rollCount) {

        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(calendar, rollCount);
        return ca.getTime();
    }

    /**
     * 取得去年的今天
     * @return String 去年的今天
     */
    public static Date getLastYearOfToday() {
        return rollYear(new Date(), -1);
    }

    /**
     * 取得日期字符串
     * @param strDate 日期
     * @param pattern 日期格式
     * @return Date 转换后日期类型的值
     * @throws SystemException
     */
    public static Date parseDate(String strDate, String pattern) throws SystemException {
        if (StringUtil.isEmpty(strDate)) {
            return null;
        }
        format.applyPattern(pattern);
        try {
            return format.parse(strDate);
        } catch (ParseException e) {
            throw new SystemException(e, e.getMessage());
        }
    }

    /**
     * 取得当前年
     * @return String 年的字符型值
     */
    public static String getYear() {
        return formatDate(new Date(), DATE_FMT_YYYY);
    }

    /**
     * 取得去年
     * @return String 去年的字符型值
     */
    public static String getLastYear() {
        return formatDate(getLastYearOfToday(), DATE_FMT_YYYY);
    }

    /**
     * 取得当前年月日
     * @return String 年月日的字符型值
     */
    public static String getYearMonthDay() {
        return formatDate(new Date(), DATE_FMT_YYYY_MM_DD);
    }

    /**
     * 取得当前年月日时分秒
     * @return String 年月日时分秒的日期型值
     */
    public static String getSystemTime() {
    	Date date = new Date();
    	SimpleDateFormat from = new SimpleDateFormat("yyyyMMddHHmmss"); 
    	return from.format(date);

    }
    /**
     * 取得当前年月日时分秒
     * @return String 年月日时分秒的日期型值
     */
    public static String getSystemTimeMs() {
    	Date date = new Date();
    	SimpleDateFormat from = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
    	return from.format(date);

    }
    /**
     * 取得当前年月日时分秒
     * @return String 年月日时分秒的日期型值
     */
    public static Date getSystemTimeSS(){
    	return parseDate(getSystemTime(), "yyyyMMddHHmmss");
    }
    /**
     * 取得当前年月日时分秒
     * @return Date 年月日时分秒的日期型值
     */
    public static Date getSystemTimeDate() {
    	return parseDate(getYearMonthDay(), "yyyy-MM-dd");
    }
    /**
     * 取得去年月日(去年的今天)
     * @return String 去年月日的字符型值
     */
    public static String getLastYearMonthDay() {
        return formatDate(getLastYearOfToday(), DATE_FMT_YYYY_MM_DD);
    }
}
