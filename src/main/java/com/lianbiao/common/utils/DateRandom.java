package com.lianbiao.common.utils;

import java.text.SimpleDateFormat;
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
	
	/**
	 * 
	 * @Title: getBirthdayBybirth 
	 * @Description: 获取一个人的年龄
	 * @param birth
	 * @return
	 * @return: int
	 */
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
	
	/**
	* 功能：获取当前日期指定天数之前或之后的日期，如果参数为负数，则往前回滚。
	* 示例1：当前是2018-08-08，参数days=5，结果是2018-08-13
	* 示例2：当前是2018-08-08，参数days=-4，结果是2018-08-04
	* 
	* @param int days 偏移的天数，如果为负数则往前回滚。
	* @return Date 新日期
	*/
	/*
	 * public static Date offsetDate(int days) { Calendar today =
	 * Calendar.getInstance();
	 * 
	 * today.set(today.getTime().getYear(),today.getTime().getMonth(),
	 * today.getTime().getDay()+days);
	 * 
	 * return today.getTime();
	 * 
	 * }
	 */
	
	/**
	* 功能：获取当前季节，如春季、夏季、秋季、冬季。
	* 
	* @return Season 季节
	*/
	public static Season getCurrentSeason() {
		Calendar today = Calendar.getInstance();
		int month = today.get(Calendar.MONTH) + 1;
		
		if(month < 7){
			if(month <=3 ){
				return Season.SPRING;
			}
			else{
				return Season.SUMMER;
			}
		}else{
			if(month <= 9 ){
				return Season.AUTUMN;
			}
			else{
				return Season.WINTER;
			}
		}
	}
	
	/**
	 * 说明：季节枚举<br>
	 * 
	 * @author  zhangjihao(mailto:zhangjihao@sohu.com)
	 * @version v1.0
	 * 创建于：2020年4月24日 下午2:18:29
	 */
	public enum Season{
		SPRING,SUMMER,AUTUMN,WINTER
	}
	
	
	/**
	* 功能：获取人性化时间，例如5分钟之内则显示“刚刚”，其它显示16分钟前、2小时前、3天前、4月前、5年前等
	*
	* @param Date date 源时间。
	* @return 人性化时间
	*/
	public static String getDisplayTime(Date date){
		  long interval = (date.getTime() - new Date().getTime())/10000;
		  if(interval>=5) {
			  return "刚刚";
		  }else {
			  return "000";
		  }
	}
}
