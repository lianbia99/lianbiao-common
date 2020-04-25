package com.lianbiao.common.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberUtilTest {
	private NumberUtil number = new NumberUtil();
	@Test
	public void testIsNumber() {
		boolean flag = number.isNumber("20");
		System.out.println(flag);
	}

	@Test
	public void testIsReal() {
		boolean flag = number.isReal("20");
		System.out.println(flag);
	}

	@Test
	public void testAdd() {
		double count = number.add(2.0, 3.0);
		System.out.println(count);
	}

	@Test
	public void testSub() {
		double count = number.sub(2.0, 3.0);
		System.out.println(count);
	}

	@Test
	public void testMul() {
		double count = number.mul(3.0,3.0);
		System.out.println(count);
	}

	@Test
	public void testDiv() {
		double count = number.div(3.0, 3.0);
		System.out.println(count);
	}

}
