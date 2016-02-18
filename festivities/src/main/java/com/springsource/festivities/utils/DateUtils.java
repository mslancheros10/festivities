package com.springsource.festivities.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utilities of Dates
 * @author mlancheros
 *
 */
public class DateUtils {
	
	/**
	 * Festivity's format date
	 */
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	
	/**
	 * Convert a date into string by format date
	 * @param date Date to convert
	 * @return String converted
	 */
	public static String convertToUTCFormat(Date date){
		return simpleDateFormat.format(date);
	}
	
	/**
	 * Convert a String into Date by format date 
	 * @param dateString String to convert
	 * @return Date converted
	 * @throws ParseException
	 */
	public static Date convertToDateFromUTCFormat(String dateString) throws ParseException{
		return simpleDateFormat.parse(dateString);
	}

}
