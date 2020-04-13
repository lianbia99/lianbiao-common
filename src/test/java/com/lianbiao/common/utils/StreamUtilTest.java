package com.lianbiao.common.utils;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

public class StreamUtilTest {

	@Test
	public void test() throws IOException {
		InputStream in = this.getClass().getResourceAsStream("/data2.txt");
		List<String> list = StreamUtil.readFileList(in);
		for (String string : list) {
			String[] s = string.split("\\|\\|");
			System.out.println(s[0]);
			System.out.println(s[1]);
			System.out.println(s[2]);
			System.out.println(s[3]);
			System.out.println(s[4]);
			
			
		}
	}

}
