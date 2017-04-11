package com.gooday.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Integer getCurrentUnixTime(){
		return Integer.valueOf((int) (System.currentTimeMillis() / 1000));
	}
	
}
