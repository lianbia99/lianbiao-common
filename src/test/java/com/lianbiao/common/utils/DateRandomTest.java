package com.lianbiao.common.utils;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.lianbiao.common.utils.DateRandom.Season;
import com.sun.org.apache.bcel.internal.generic.SIPUSH;

public class DateRandomTest {

	private DateRandom date = new DateRandom();
	@Test
	public void testDateRandom() {
		Date randomDate = date.dateRandom(new Date(100000000), new Date());
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(simple.format(randomDate));
	}

	@Test
	public void testGetBirthdayBybirth() {
		int count = date.getBirthdayBybirth(new Date(10000000000L));

		System.out.println(count);
	}

	@Test
	public void testGetEndMonth() {
		Date endMonth = date.getEndMonth(new Date(10000000000L));
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(simple.format(endMonth));
	}

	@Test
	public void testGetInitMonth() {
		Date initMonth = date.getInitMonth(new Date(100000000L));
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(simple.format(initMonth));
	}

	@Test
	public void testGetDateByBefore() {
		Date dateByBefore = date.getDateByBefore();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(simple.format(dateByBefore));

	}

	@Test
	public void testOffsetDate() {
		
	}

	@Test
	public void testGetCurrentSeason() {
		Season currentSeason = date.getCurrentSeason();
		System.out.println(currentSeason);
	}

	@Test
	public void testGetDisplayTime() {
		fail("Not yet implemented");
	}

}
