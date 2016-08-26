package com.trusdom.fdip.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 流水号/批次号生成
 * @author zjb Feb 19, 2016  3:22:04 PM 
 *
 */
public class CodeBuilder {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	
	/**
	 * 交易流水号
	 * @param prefix
	 * @return
	 */
	public synchronized static String generatorTradeNo(String prefix){
		return ((null == prefix)?"":prefix)+sdf.format(new Date());
	}
	
	public static void main(String[] args) {
		System.err.println(generatorTradeNo("THS"));
	}
}
