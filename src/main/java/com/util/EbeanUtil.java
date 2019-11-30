package com.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;


import io.ebean.Ebean;
import io.ebean.SqlQuery;
import io.ebean.SqlRow;

public class EbeanUtil {
	/**
	 * 转list
	 * 
	 * @param sqlQuery
	 * @param parameters
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> toList(List<SqlRow> list, Class<T> clazz) {
		ArrayList<T> objects = new ArrayList<>();
		for (SqlRow sqlRow : list) {
			T t = toModel(sqlRow, clazz);
			objects.add(t);
		}

		return objects;
	}
	/**
	 * sql转list
	 * @param sql
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> toList(String sql, Class<T> clazz) {
		List<SqlRow> rows = Ebean.createSqlQuery(sql).findList();
		return toList(rows, clazz);
	}

	/**
	 * 单个对象转换
	 * 
	 * @param _form
	 * @param field
	 */
	private static void assignValue(Object _form, Field field, SqlRow row) {
		try {
			String colName = field.getName();
			field.setAccessible(true);
			Object object = row.get(colName);
			if (object == null) {
				Column column = field.getAnnotation(Column.class);
				if (column != null) {
					colName = column.name();
					object = row.get(colName);
				}
			}
			if (object == null) {
				return;
			}
			if (field.getType().getName().equals("java.lang.Long")) {
				field.set(_form, row.getLong(colName));
			} else if (field.getType().getName().equals("java.lang.Integer")) {
				field.set(_form, row.getInteger(colName));
			} else if (field.getType().getName().equals("java.lang.Float")) {
				field.set(_form, row.getFloat(colName));
			} else if (field.getType().getName().equals("java.lang.Double")) {
				field.set(_form, row.getDouble(colName));
			} else if (field.getType().getName().equals("java.lang.Boolean")) {
				field.set(_form, row.getBoolean(colName));
			} else if (field.getType().getName().equals("java.util.Date")) {
				field.set(_form, row.getUtilDate(colName));
			} else {
				field.set(_form, row.get(colName));
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 转换为实体类
	 * 
	 * @param clazz
	 * @return
	 */
	public static <T> T toModel(SqlRow row, Class<T> clazz) {
		T model = null;
		try {
			model = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return model;
		}

		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			assignValue(model, field, row);
		}

		Field[] superFields = clazz.getSuperclass().getDeclaredFields();
		for (Field field : superFields) {
			assignValue(model, field, row);
		}

		return model;
	}
}
