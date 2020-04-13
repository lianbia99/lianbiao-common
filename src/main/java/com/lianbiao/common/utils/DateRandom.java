package com.lianbiao.common.utils;

import java.util.Calendar;
import java.util.Date;

public class DateRandom {
	/**
	 * 返回一个随机日期
	 */
	public static Date dateRandom(Date startDate,Date endDate) {
		long t1 = startDate.getTime();
		long t2 = endDate.getTime();
		if(t2<t1) throw new RuntimeException("参数异常：开始日期不能大于结束日期");
		long date = (long)(Math.random()*(t2-t1))+t1;
		return new Date(date);
	}
	

	public static int getBirthdayBybirth(Date birth) {
		Calendar c=Calendar.getInstance();
		//出生日期初始化日历类
		c.setTime(birth);
		//获取出生年
		int b_year = c.get(Calendar.YEAR);
		int b_month = c.get(Calendar.MONTH);
		int b_day = c.get(Calendar.DAY_OF_MONTH);
		
		c.setTime(new Date());
		int s_year= c.get(Calendar.YEAR);
		int s_month = c.get(Calendar.MONTH);
		int s_day = c.get(Calendar.DAY_OF_MONTH);
		
		int age=s_year-b_year;
		
		if(s_month<b_month) {
			age--;
		}
		if(s_month==b_month && s_day<b_day) {
			age--;
		}
		return age;
	}
	/**
	 * 
	 * @Title: getInitMonth 
	 * @Description: 返回一个月月末
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getEndMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		//1.月份加一
		c.add(Calendar.MONTH, 1);
		//2.变成月初
		Date initMonth = getInitMonth(c.getTime());
		//3.再次初始化 减一秒
		c.setTime(initMonth);
		c.add(Calendar.SECOND, -1);
		
		return c.getTime();
	}
	/**
	 * 
	 * @Title: getInitMonth 
	 * @Description: 返回日期的月初
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getInitMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE,0 );
		c.set(Calendar.SECOND, 0);
		
		return c.getTime();
	}
	
	/**
	 * 
	 * @Title: getDateByBefore 
	 * @Description: 24小时热文
	 * @return
	 * @return: Date
	 */
	public  static Date getDateByBefore() {
		//用系统时间初始化Calender
		Calendar c = Calendar.getInstance();
		//让系统时间减去1天
		c.add(Calendar.DAY_OF_MONTH, -1);
		return c.getTime();
	}
}
