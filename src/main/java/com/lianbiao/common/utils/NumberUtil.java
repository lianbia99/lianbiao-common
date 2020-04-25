package com.lianbiao.common.utils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtil {

	//是否是数字类型  包含 正负数，小数
	public static boolean isNumber(String str) {
		Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
		String bigStr;
		try {
		bigStr = new BigDecimal(str).toString();
		} catch (Exception e) {
		return false;//异常 说明包含非数字。
		}

		Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
		if (!isNum.matches()) {
		return false;
		}
		return true;
	}
	
	/**
	* 功能：判断是否全部为实数
	* 示例：
	* NumberUtil.isNUmber("abc") -> false
	* NumberUtil.isNUmber("5.6") -> true
	* NumberUtil.isNUmber("1234") -> true
	*/
	public static boolean isReal(String src){
	    return isNumber(src);
	}
	
	/**
	* 功能：提供精确的加法运算。
	* @param v1 被加数
	* @param v2 加数
	* @return 两个参数的和
	*/
	public static double add(double v1, double v2){
			BigDecimal big1 = new BigDecimal(v1);
			BigDecimal big2 = new BigDecimal(v2);
			BigDecimal big = big1.add(big2);
			return big.doubleValue();
	}
	
	/**
	 * 提供精确的减法运算。
	 * @param v1 被减数
	 * @param v2 减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1,double v2){
		BigDecimal big1 = new BigDecimal(v1);
		BigDecimal big2 = new BigDecimal(v2);
		BigDecimal big = big1.subtract(big2);
		return big.doubleValue();
	}
	
	/**
	 * 提供精确的乘法运算。
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1,double v2){
		BigDecimal big1 = new BigDecimal(v1);
		BigDecimal big2 = new BigDecimal(v2);
		BigDecimal big = big1.multiply(big2);
		return big.doubleValue();
	}
	
	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
	 * 小数点以后10位，以后的数字四舍五入。
	 * @param v1 被除数
	 * @param v2 除数
	 * @return 两个参数的商
	 */
	
	  public static double div(double v1,double v2){
		BigDecimal big1 = new BigDecimal(v1);
		BigDecimal big2 = new BigDecimal(v2);
		BigDecimal big = big1.divide(big2);
		return big.doubleValue();
	  }
	 
	
	/**
	 * 提供精确的小数位四舍五入处理。
	 * @param v 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	/*
	 * public static double round(double v,int scale){ //课外实现 }
	 */
}
