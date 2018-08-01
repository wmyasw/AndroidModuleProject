package com.wmy.lib_common.utils;


import android.util.Log;

import com.wmy.lib_common.BuildConfig;


/********************************************************************
 *[Author]guangyuan 2011-05-26 										*
 *[Version]Ver 1.0 copyRight 2010									*
 *[Function]日志消息处理类：异常|警告|成功 								*
 ********************************************************************/
public class LogUtils {
	
	/**日志输出级别 0为不输出*/
	private static int logMode = Log.ERROR;
	
	/**
	 * 输出Error信息
	 * 
	 * @param tag
	 * 			异常信息标识	
	 * @param msg
	 * 			异常信息
	 */
	public static void e(String tag, String msg){
		
		if (BuildConfig.DEBUG)
			if (Log.ERROR <= logMode)
				Log.e(tag, msg);
	}
		
	/**
	 * 输出警告信息
	 * 
	 * @param tag
	 * 			错误信息标识	
	 * @param msg
	 * 			错误信息
	 */
	public static void w(String tag, String msg){
		
		if (BuildConfig.DEBUG)
			if (Log.WARN <= logMode)
				Log.w(tag, msg);
	}
		
	/**
	 * 输出普�?信息
	 * 
	 * @param tag
	 * 			普�?信息	
	 * @param msg
	 * 			异常信息
	 */
	public static void i(String tag, String msg){
		
		if (BuildConfig.DEBUG)
			if (Log.INFO <= logMode)
				Log.i(tag, msg);
	}
	
	
	/**
	 * 输出debug信息
	 * 
	 * @param tag
	 * 			调试信息标识	
	 * @param msg
	 * 			调试信息
	 */
	public static void d(String tag, String msg){
		
		if (BuildConfig.DEBUG)
			if (Log.DEBUG <= logMode)
				Log.d(tag, msg!=null?msg:"");
	}



}
