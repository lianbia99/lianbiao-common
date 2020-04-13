package com.lianbiao.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {
	
	//读取一个io流集合中
	public static List<String> readFileList(InputStream in) throws IOException{
		List<String> list = new ArrayList<String>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(in));
		String str = "";
		while((str=bf.readLine())!=null) {
			list.add(str);
		}
		return list;
	}
}
