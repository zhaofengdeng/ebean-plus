package com.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class DateUtil {
	/**
	 * @name 格式化 date 类型
	 * @description 去除 date 类型的 时分秒
	 * @author 赵丰登
	 * @return
	 */
	public static Date noTime(Date date) {

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		Date dateTemp = new Date(date.getTime() - gc.get(gc.HOUR_OF_DAY) * 60 * 60 * 1000
				- gc.get(gc.MINUTE) * 60 * 1000 - gc.get(gc.SECOND) * 1000);
		return dateTemp;
	}

	/**
	 * @name 根据输入时间增加天数
	 * @description 根据输入时间增加天数
	 * @author 赵丰登
	 * @return
	 */
	public static Date push(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}

}
