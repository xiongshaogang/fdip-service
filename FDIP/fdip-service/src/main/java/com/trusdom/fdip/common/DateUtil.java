package com.trusdom.fdip.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static String yestoday(SimpleDateFormat sdf){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return sdf.format(cal.getTime());
	}
	
	public static Date yestoday(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}
	
	public static String timePoint(Date date, String time){
		return Constants.SDF_DATE.format(date).concat(" "+time);
	}
	
	public static String dateStart(Date date){
		return timePoint(date, "00:00:00");
	}
	
	public static String dateEnd(Date date){
		return timePoint(date, "23:59:59");
	}
	
	public static String currentDate(SimpleDateFormat sdf){
		return sdf.format(new Date());
	}
	
	public static String nextDay(String day, SimpleDateFormat sdf){
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(day));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.add(Calendar.DATE, 1);
		return sdf.format(cal.getTime());
	}
	
	public static String prevDay(String day, SimpleDateFormat sdf){
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(day));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.add(Calendar.DATE, -1);
		return sdf.format(cal.getTime());
	}
}
