package com.util;

import java.util.Date;


import com.util.base.StringUtil;

import io.ebean.ExpressionList;

public class EbeanELUtil {
	/**
	 * 如果不为空，拼接key like '%value%'
	 * 
	 * @param el
	 * @param key
	 * @param value
	 */
	public static void like(ExpressionList el, String key, String value) {
		if (value != null && StringUtil.isNotNullOrEmpty(value.toString())) {
			el.like(key, "%" + value + "%");
		}
	}

	/**
	 * 如果不为空，拼接key = 'value'
	 * 
	 * @param el
	 * @param key
	 * @param value
	 */
	public static void eq(ExpressionList el, String key, Object value) {
		if (value != null && StringUtil.isNotNullOrEmpty(value.toString())) {
			el.eq(key, value);
		}
	}

	/**
	 * 如果不为空拼接开始时间
	 * 
	 * @param el
	 * @param key
	 * @param value
	 */
	public static void beginDate(ExpressionList el, String key, Date value) {
		if (value != null) {
			el.ge(key, DateUtil.noTime(value));
		}
	}

	/**
	 * 如果不为空拼接结束时间
	 * 
	 * @param el
	 * @param key
	 * @param value
	 */
	public static void endDate(ExpressionList el, String key, Date value) {
		if (value != null) {
			el.lt(key, DateUtil.noTime(DateUtil.push(value, 1)));
		}
	}
}
