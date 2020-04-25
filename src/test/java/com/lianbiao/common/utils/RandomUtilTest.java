package com.lianbiao.common.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomUtilTest {

	@Test
	public void testRandom() {
		int r = RandomUtil.random(1,3);
		System.out.println(r);
	}

	@Test
	public void testSubRandom() {
		int[] sub = RandomUtil.subRandom(1, 5, 2);
		for (int i : sub) {
			System.out.println(i);
		}
	}

	@Test
	public void testRandomCharacter() {
		char str = RandomUtil.randomCharacter();
		System.out.println(str);
	}

	@Test
	public void testRandomString() {
		String str = RandomUtil.randomString(5);
		System.out.println(str);
	}

}
