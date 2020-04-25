package com.lianbiao.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName: WebUtil 
 * @Description: web层工具类
 * @author: 连彪
 * @date: 2020年4月25日 下午7:39:50
 */
public class WebUtil {
	/**
	 * 
	 * 功能：
	 *
	 * @param inputStream
	 * @param response
	 * @param filename 文件名
	 * @param contentType 可以通过servletContext.getMimeType(文件名)获取
	 * @param inline 是否在浏览器窗口打开还是下载另存为
	 * @throws IOException
	 */
	public void download(InputStream inputStream, HttpServletResponse response, String filename, String contentType, boolean inline) throws IOException{
		response.addHeader("pragma","NO-cache");
		response.addHeader("Cache-Control","no-cache");
		response.addDateHeader("Expries",0);
		
		response.setHeader("Content-Type", StringUtil.hasText(contentType) ? contentType : "application/x-download");
		//response.setHeader("Content-Length", "0");
		
		try {
			filename = new String(filename.getBytes("UTF-8"), "ISO8859_1");
		}catch (Exception e) {e.printStackTrace();}
		
		response.setHeader("Content-Disposition", "" + (inline ? "inline" : "attachment") +"; filename=\"" + filename + "\"");
		
		StreamUtil.copy(inputStream, response.getOutputStream(), true, false);
		response.flushBuffer();
		
	}
	
	public void download(File localFile, HttpServletResponse response, String contentType, boolean inline) throws IOException{
		response.setHeader("Content-Length", String.valueOf(localFile.length()));
		download(new FileInputStream(localFile), response, localFile.getName(), contentType, inline);
	}
	

	/**
	* 功能：获取前端字符串参数
	* @param request 
	* @param name 参数名
	* @param defaultValue 默认值
	* @return
	*/
	public static String getStringByRequestParameter(HttpServletRequest request, String name, String defaultValue){
		String value = request.getParameter(name);
		return StringUtil.hasText(value) ? value : defaultValue;
	}
	
	/**
	* 功能：获取布尔类型参数
	* 示例：http://www.zhang.com/show.do?id=1  -> http://www.zhang.com/show.do?id=a
	* 
	* @param HttpServletRequest request 
	* @param String name 参数名
	* @param int defaultValue 默认值
	* @return
	*/
	public static int getIntByRequestParameter(HttpServletRequest request, String name, int defaultValue){
		String value = request.getParameter(name);
		if(StringUtil.hasText(value) && NumberUtil.isNumber(value)){
			return Integer.parseInt(value);
		}
		
		return defaultValue;
	}
	
	
	
	/**
	* 功能：获取布尔类型参数
	* @param HttpServletRequest request 
	* @param String name 参数名
	* @param boolean defaultValue 默认值
	* @return
	*/
	public static boolean getBooleanByRequestParameter(HttpServletRequest request, String name, boolean defaultValue){
		//TODO 实现代码
		return false;
	}
	
	
	/**
	* 功能：获取URL全部地址，包含参数
	* 示例：http://www.zhang.com/show.do?id=1&
	* @param request 
	* @param String...ignoreParams 忽略的参数
	* 
	* @return
	*/
	public static String getUrl(HttpServletRequest request, String...ignoreParams){
		//StringBuffer url = request.getRequestURL();//这里有个bug，如果是forward地址，它不能取实际地址，只能取浏览器上的地址。
		
		Object forwardUrl = request.getAttribute("javax.servlet.forward.servlet_path");
		StringBuffer url = new StringBuffer();
		url.append(forwardUrl != null ? forwardUrl : request.getRequestURL());
			
		
		url.append('?');
		Enumeration<String> enumeration = request.getParameterNames();
		while(enumeration.hasMoreElements()){
			String name = enumeration.nextElement();
			String value = request.getParameter(name);
			
			//判断该参数是否忽略
			boolean ignoreName = false;
			for(String ignoreParam : ignoreParams){
				if(name.equals(ignoreParam)){
					ignoreName = true;
					break;
				}
			}
			
			//不忽略的参数追加到URL地址上
			if(!ignoreName){
				url.append(name).append('=').append(value).append('&');
			}
			
		}
		String temp = url.toString();
		if(temp.endsWith("?") || temp.endsWith("&")){
			url.deleteCharAt(url.length() - 1);
		}
		
		return url.toString();
	}
}
