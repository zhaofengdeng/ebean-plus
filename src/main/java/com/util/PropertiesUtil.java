package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 属性Util
 * 
 * @author 赵丰登
 *
 */
public class PropertiesUtil {
	public static String toString(Object obj) {
		if (obj == null) {
			return "null";
		}
		String fieldName = obj.getClass().getTypeName();
		if ("java.util.Date".equals(fieldName)) {
			String format = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format((Date) obj);
		}
		return obj.toString();
	}

}
