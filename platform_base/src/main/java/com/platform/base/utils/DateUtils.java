package com.platform.base.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.platform.base.utils.CommonUtils;

public class DateUtils {

	public static String format = "yyyy-MM-dd HH:mm:ss";

	public static String format_day = "yyyy-MM-dd";

	public static String format_ms = "yyyy-MM-dd HH:mm:ss.S";
	//一天包含的毫秒数
	private static final long A_DAY_MILLISECONDS = 1000 * 60 * 60 * 24;
	//年月日格式化对象
	private static final DateFormat simpleDateFormat = new SimpleDateFormat(format_day);
	//年月日时分秒格式化对象
	private static final DateFormat fullDateFormat = new SimpleDateFormat(format);

    private  static int weeks = 0;

	/**
	 * 格式化日期 年月日形式
	 * 
	 * @param date
	 *            日期
	 * @return 日期字符串
	 */
	public static String formatSimpleDate(Date date) {
		if(date == null){
			return null;
		}
		return simpleDateFormat.format(date);
	}
	/**
	 * 全日期格式格式化
	 * @param date
	 * @return
	 */
	public static String formatFullDate(Date date) {
		if(date == null){
			return null;
		}
		return fullDateFormat.format(date);
	}
	public static Date parseSimpleDate(String dateStr){
		Date date = null;
		if(CommonUtils.notEmpty(dateStr)){
			try {
				date = simpleDateFormat.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
//				log.error("解析日期字符串报错,dateStr="+dateStr, e);
			}
		}
		return date;
	}
	
	public static Date parseFullDate(String dateStr){
		Date date = null;
		if(CommonUtils.notEmpty(dateStr)){
			try {
				date = fullDateFormat.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
//				log.error("解析日期字符串报错,dateStr="+dateStr, e);
			}
		}
		return date;
	}

    public static Date parseDateWithFormat(String dateStr,String format){
        Date date = null;
        if(CommonUtils.notEmpty(dateStr)){
            try {
                DateFormat sf = CommonUtils.isEmpty(format)?fullDateFormat:new SimpleDateFormat(format);
                date = sf.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    /**
	 * 获取一天的第一秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date fistSecondOfDate(Date date) {
		if (date == null) {
			return null;
		}
		long time = new Date().getTime()/A_DAY_MILLISECONDS*A_DAY_MILLISECONDS-8*60*60*1000;
		return new Date(time);
	}
	
	/**
	 * 获取一天的最后一秒
	 * @param date
	 * @return
	 */
	public static Date lastSecondOfDate(Date date) {
		if (date == null) {
			return null;
		}
		long time = (new Date().getTime()/A_DAY_MILLISECONDS+1)*A_DAY_MILLISECONDS-8*60*60*1000-1;
		return new Date(time);
	}

	public static Date parseDateFromString(String date) {
		return parseDateFromString(date, format);
	}

	public static Date parseDateFromString(String date, String format) {
		return parseDateFromString(date, format, Locale.US);
	}

	public static Date parseDateFromString(String date, String format,
			Locale locale) {
		SimpleDateFormat fm = new SimpleDateFormat(format, locale);
		ParsePosition pos = new ParsePosition(0);
		return fm.parse(date, pos);
	}

	public static String parseStringFromDate(Date date) {
		return parseStringFromDate(date, format);
	}

	public static String parseStringFromDate(Date date, String format) {
		return parseStringFromDate(date, format, Locale.US);
	}

	public static String parseStringFromDate(Date date, String format,
			Locale locale) {
		return parseStringFromDate(date, format, locale, null);
	}

	public static String parseStringFromDate(Date date, String format,
			Locale locale, TimeZone tz) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat fm = new SimpleDateFormat(format, locale);
		if (tz != null) {
			fm.setTimeZone(tz);
		}
		return fm.format(date);
	}

	public static Date getDate() {
        return getDate(-1, -1, -1, -1, -1, -1);
    }

	public static Date getDate(int year, int month, int dayOfMonth, int hour,
			int minute, int second) {
		return specificDate(year, month, dayOfMonth, hour, minute, second, 0,
                null);
	}

	public static Date specificDate(int year, int month, int dayOfMonth,
			int hour, int minute, int second, int milliSecond, TimeZone zone) {
		Calendar c = (zone == null) ? Calendar.getInstance() : Calendar
				.getInstance(zone);
		if (year >= 0)
			c.set(Calendar.YEAR, year);
		if (month >= 0)
			c.set(Calendar.MONTH, month);
		if (dayOfMonth >= 0)
			c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		if (hour >= 0)
			c.set(Calendar.HOUR_OF_DAY, hour);
		if (minute >= 0)
			c.set(Calendar.MINUTE, minute);
		if (second >= 0)
			c.set(Calendar.SECOND, second);
		if (milliSecond >= 0)
			c.set(Calendar.MILLISECOND, milliSecond);
		return c.getTime();
	}

    public static String getTwoDay(String sj1, String sj2) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        long day = 0;
        try {
            Date date = myFormatter.parse(sj1);
            Date mydate = myFormatter.parse(sj2);
            day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            return "";
        }
        return day + "";
    }

    /**
     * 根据日期推算是周几
     *
     * @Title: getWeek
     * @param sdate
     * @return
     * @Author: 王华杰 2013-3-21 上午11:08:49
     */
    public static String getWeek(String sdate) {
        // 先转换为时间
        Date date = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);

       switch (c.get(Calendar.DAY_OF_WEEK)){
           case Calendar.MONDAY:
               return "星期一";
           case Calendar.TUESDAY:
               return "星期二";
           case Calendar.WEDNESDAY:
               return "星期三";
           case Calendar.THURSDAY:
               return "星期四";
           case Calendar.FRIDAY:
               return "星期五";
           case Calendar.SATURDAY:
               return "星期六";
           case Calendar.SUNDAY:
               return "星期日";
           default:
               return "星期一";
       }
    }

    /**
     * 字符串转日期
     *
     * @Title: strToDate
     * @param strDate
     * @return
     * @Author: 王华杰 2013-3-21 上午11:07:49
     */
    public static Date strToDate(String strDate) {
        return strToDate(strDate,"yyyy-MM-dd");
    }

    public static Date strToDate(String strDate,String format) {
        AssertUtils.notNull(strDate);
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 获得当前日期与本周日相差的天数
     *
     * @Title: getMondayPlus
     * @return
     * @Author: 王华杰 2013-3-21 上午11:11:33
     */
    private static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        if (dayOfWeek == 1) {
            return 0;
        } else {
            return 1 - dayOfWeek;
        }
    }

    /**
     * 获得上周星期一的日期
     *
     * @Title: getPrevWeekday
     * @return
     * @Author: 王华杰 2013-3-21 上午11:10:09
     */
    public String getPrevWeekday() {
        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday + " 00:00:00";
    }

    /**
     * 获得上周星期日的日期
     *
     * @Title: getPrevWeekSunday
     * @return
     * @Author: 王华杰 2013-3-21 上午11:13:31
     */
    public static String getPrevWeekSunday() {
        weeks = 0;
        weeks--;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + weeks);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday ;
    }

    
    /**
     * 获取当月第一天
     *
     * @Title: getFirstDayOfMonth
     * @return
     * @Author: 王华杰 2013-3-21 上午11:15:10
     */
    public static String getFirstDayOfMonth() {
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        return simpleDateFormat.format(lastDate.getTime());
    }

    /**
     * 上月第一天
     *
     * @Title: getPrevMonthFirstDay
     * @return
     * @Author: 王华杰 2013-3-21 上午11:35:40
     */
    public static String getPrevMonthFirstDay() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.add(Calendar.MONTH, -1);// 减一个月，变为上月的1号
        // lastDate.add(Calendar.DATE,-1);//减去一天，变为当月最后一天

        str = sdf.format(lastDate.getTime());
        return str;
    }

    /**
     * 获得上月最后一天的日期
     *
     * @Title: getPrevMonthEnd
     * @return
     * @Author: 王华杰 2013-3-21 上午11:16:57
     */
    public static String getPrevMonthLastDay() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, -1);// 减一个月
        lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String getToday(String s) {
        return parseStringFromDate(getDate(-1, -1, -1, -1, -1, -1), s);
    }

    //获取指定日期之前的n天
    public static String getPrevDay(String date, int i) {
        return getPrevDay(date, format_day, i);
    }

    //获取指定日期之前的n天
    public static String getPrevDay(String date,String format, int i) {
        AssertUtils.notNull(date);
        format = CommonUtils.isEmpty(format)?format_day:format;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            Date d = dateFormat.parse(date);
            return getPrevDay(d,format,i);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取指定日期之前的n天
    public static String getPrevDay(Date date,String format,int i) {
        Calendar calendar = Calendar.getInstance();
        long time = calendar.getTime().getTime()-date.getTime();
        long intervalDay = (time/1000/3600/24);
        if (intervalDay>0){
            calendar.add(Calendar.DATE,-Math.abs(CommonUtils.toInt(intervalDay)));
        } else if(intervalDay<0){
            calendar.add(Calendar.DATE,Math.abs(CommonUtils.toInt(intervalDay))+1);
        }
        calendar.add(Calendar.DATE,-Math.abs(i));
        return parseStringFromDate(calendar.getTime(),format);
    }


    //获取指定日期之后的n天
    public static String getNextDay(Date date,String format,int i) {
        Calendar calendar = Calendar.getInstance();
        long time = calendar.getTime().getTime()-date.getTime();
        long intervalDay = (time/1000/3600/24);
        if (intervalDay>0){
            calendar.add(Calendar.DATE,-Math.abs(CommonUtils.toInt(intervalDay)));
        }else if(intervalDay<0) {
            calendar.add(Calendar.DATE,Math.abs(CommonUtils.toInt(intervalDay)-1));
        }
        calendar.add(Calendar.DATE,Math.abs(i));
        return parseStringFromDate(calendar.getTime(), format);
    }


    //获取指定日期之后的n天
    public static String getNextDay(String date, int i) {
        return getNextDay(date, format_day, i);
    }

    //获取指定日期之后的n天
    public static String getNextDay(String date,String format, int i) {
        AssertUtils.notNull(date);
        format = CommonUtils.isEmpty(format)?format_day:format;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            Date d = dateFormat.parse(date);
            return getNextDay(d, format, i);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    //获取今天之前的n天
    public static String getCurrDayPrevDay(String format, int i) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -Math.abs(i));
        String statTime = new SimpleDateFormat(format).format(cal.getTime());
        return statTime;
    }

    //获取今天之前的n天
    public static String getCurrDayPrevDay(int i) {
       return getCurrDayPrevDay(format_day,i);
    }

    //获取今天之前的n天
    public static String getCurrDayNextDay(int i) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, Math.abs(i));
        String statTime = new SimpleDateFormat(format_day).format(cal.getTime());
        return statTime;
    }

    //获取今天之前的n天
    public static String getCurrDayNextDay(String format, int i) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, Math.abs(i));
        String statTime = new SimpleDateFormat(format).format(cal.getTime());
        return statTime;
    }

    public static List<Date> getIntervalDate(Date date1, Date date2) {
        date1 = parseSimpleDate(formatSimpleDate(date1));
        date2 = parseSimpleDate(formatSimpleDate(date2));

        Date start = date1.getTime()>date2.getTime()?date2:date1;
        Date end = date1.getTime()>date2.getTime()?date1:date2;

        Calendar cal = Calendar.getInstance();
        int ida = CommonUtils.toInt((cal.getTime().getTime() - start.getTime()) / 1000 / 3600 / 24);
        cal.add(Calendar.DATE,-ida);

        int intervalDay = CommonUtils.toInt((end.getTime() - start.getTime()) / 1000 / 3600 / 24);

        List<Date> dates = new ArrayList<Date>(0);

        int loop = Math.abs(intervalDay);
        if (intervalDay>0){
            dates.add(cal.getTime());
        }
        for (int i=0;i<loop;i++){
            if (intervalDay>0){
                cal.add(Calendar.DATE,1);
            }else if(intervalDay<0){
                cal.add(Calendar.DATE,-1);
            }
            dates.add(cal.getTime());
        }
        return dates;
    }

    public static List<String> getIntervalDateStr(Date startDate, Date endDate, String s) {
        List<Date> dates = getIntervalDate(startDate,endDate);
        List<String> strs = new ArrayList<String>(0);
        for (Date date:dates){
            strs.add(new SimpleDateFormat(s).format(date));
        }
        return strs;
    }

    public static List<Date> getIntervalDate(String startDate, String endDate) {
        return getIntervalDate(parseSimpleDate(startDate), parseSimpleDate(endDate));
    }

    public static List<String> getIntervalDateStr(String startDate, String endDate, String s) {
        return getIntervalDateStr(parseSimpleDate(startDate), parseSimpleDate(endDate), s);
    }

    /***
     * 
     * @param weeks
     * @return
     */
    public static String getPrevWeekSunday(int weeks) {
        weeks--;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + weeks);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday ;
    }

    public static int compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}


    public static int compare_date(String DATE1, String DATE2,String format) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                //System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                //System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
    /**
	 * 格式化日期
	 * @date  2014年11月17日
	 * @author chengxiaoqiang@languang.com
	 * @param date
	 * @param formatStyle
	 * @return
	 *
	 */
	public static String dateToStr(Date date,String formatStyle)	{
		SimpleDateFormat sdf = new SimpleDateFormat(formatStyle);
		String str = sdf.format(date);
		return str;
	}

    public static String parseStrDateWithFormat(String installtime,String s1, String s2)  {
        try {
            return new SimpleDateFormat(s2).format(new SimpleDateFormat(s1).parse(installtime));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("parseStrDateWithFormat error...");
    }

    public static String parseDateWithFormat(Date date,String format)  {
        return new SimpleDateFormat(format).format(date);
    }

    public static void main(String[] args) {

        System.out.println(DateUtils.getBeforeMinTime(new Date(), 5, format));

    }

    public static long dateDiff(String time1, String time2, String format) {
        SimpleDateFormat sd = new SimpleDateFormat(format);
        long nd = 1000*24*60*60;//一天的毫秒数
        long nh = 1000*60*60;//一小时的毫秒数
        long nm = 1000*60;//一分钟的毫秒数
        long ns = 1000;//一秒钟的毫秒数
        long diff;
        try {
            //获得两个时间的毫秒时间差异
            diff = sd.parse(time1).getTime() - sd.parse(time2).getTime();
            long day = diff/nd;//计算差多少天
            long hour = diff%nd/nh;//计算差多少小时
            long min = diff%nd%nh/nm;//计算差多少分钟
            long sec = diff%nd%nh%nm/ns;//计算差多少秒
            System.out.println("时间相差："+day+"天"+hour+"小时"+min+"分钟"+sec+"秒。");
            return Math.abs(day);
            //输出结果
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }
    
    public static long dateDiff(String startTime, String endTime,  String format, long currentTime) {   
        // 按照传入的格式生成一个simpledateformate对象    
        SimpleDateFormat sd = new SimpleDateFormat(format);    
        // 获得两个时间的毫秒时间差异   
        try {
			long start=sd.parse(startTime).getTime();
			long end=sd.parse(endTime).getTime();
				long diff = start - end;    
			    if(diff >= 0){
			    	currentTime+=diff;
			    }else {
			    	currentTime-=diff;
			    }
			    return currentTime;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
}  
    
    /**
     * 获取当前年份的当前月份有多少天（繁琐）
     * @param year
     * @param month
     * @return
     */
    public static int getMonthDay(int year, int month) {
		int result = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			result = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			result = 30;
			break;
		case 2:
			result = 28;
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
				result = 29;
			}
			break;
		}

		return result;
	}

	/**获取当前年份的当前月份有多少天(简洁)
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getMonthDays(int year, int month) {
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);

		return cal.getActualMaximum(Calendar.DATE);
	}
	
	/**
	 * 获取当前时间的前几分钟时间
	 * @param date
	 * @param min
	 * @return
	 */
	public static String getBeforeMinTime(Date date,int min,String format){
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, -min);
		
		Date newDate = calendar.getTime();
		String dateStr = DateUtils.dateToStr(newDate, format);
		return dateStr;
	}
	
	
}
