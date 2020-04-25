package com.lianbiao.common.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testHasLength() {
		boolean bool = StringUtil.hasLength("s");
		System.out.println(bool);
	}

	@Test
	public void testHasText() {
		boolean bool = StringUtil.hasText("");
		System.out.println(bool);
	}

	@Test
	public void testRandomChineseString() {
		String str = StringUtil.randomChineseString(4);
		System.out.println(str);
	}

	@Test
	public void testrandomChineseString() {
		String str = StringUtil.randomChineseString();
		System.out.println(str);
	}
	
	@Test
	public void testGenerateChineseName() {
		String name = StringUtil.generateChineseName();
		System.out.println(name);
	}
	
	@Test
	public void testisEmail() {
		System.out.println(StringUtil.isEmail("2366389936@qq.com"));
	}
	@Test
	public void testisphone() {
		System.out.println(StringUtil.isPhoneNumber("15735505865"));
	}
	@Test
	public void testisnumber() {
		System.out.println(StringUtil.isNumber("2.3"));
	}

	@Test
	public void ishttp() {
		System.out.println(StringUtil.isHttpUrl("https://www.baidu.com/"));
	}
	
	@Test
	public void testIsLetter() {
		System.out.println(StringUtil.isLetter("sdff"));
	}
	@Test
	public void testHidden() {
		System.out.println(StringUtil.hidden("15735508554", 3, 7));
	}
}
