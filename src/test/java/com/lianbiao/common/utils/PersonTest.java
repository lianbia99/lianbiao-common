package com.lianbiao.common.utils;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class PersonTest {

	@Test
	public void test() {
		SimpleDateFormat sl = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.set(2010, 3, 25);
		for(int i=0;i<10000;i++) {
			System.out.println(new Person(StringUtil.generateChineseName(), RandomUtil.random(1, 120), StringUtil.randomChineseString(140),DateRandom.dateRandom(c.getTime(),new Date())));
		}
	}

}
