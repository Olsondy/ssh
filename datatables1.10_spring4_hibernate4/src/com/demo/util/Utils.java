/*
 * All rights Reserved, Designed By DINGYONG
 * Copyright: Copyright(C) 2015
 */
package com.demo.util;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.util.StringUtils;

import com.demo.entity.DataTableObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author DINGYONG
 *
 *         2015年7月11日
 */
public class Utils {
	// 时间格式
	private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String DATE_FORMAT = "yyyy-MM-dd";

	private static SimpleDateFormat dateFormat = new SimpleDateFormat();

	/**
	 * 实例化Gson
	 */
	private static Gson gson = new GsonBuilder()
			.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
				@Override
				public Date deserialize(JsonElement json, Type type,
						JsonDeserializationContext context)
						throws JsonParseException {
					if (StringUtils.isEmpty(json)
							|| !StringUtils
									.hasLength(json.getAsString().trim()))
						return null;
					return strConvertDate(DATE_FORMAT, json.getAsString());
				}
			})
			.registerTypeAdapter(Timestamp.class,
					new JsonSerializer<Timestamp>() {// Timestamp时间格式需要带时分秒
						@Override
						public JsonElement serialize(Timestamp date, Type type,
								JsonSerializationContext context) {
							return new JsonPrimitive(dateConvertStr(
									DATETIME_FORMAT, date));
						}
					}).setDateFormat(DATE_FORMAT).setPrettyPrinting().create();

	/**
	 * 私有化工具类
	 */
	private Utils() {

	}

	/**
	 * @return 获取gson
	 */
	public static Gson getGson() {
		return gson;
	}

	/**
	 * @param strArray
	 *            String类型的数组
	 * @return
	 */
	public static Integer[] StringArrayConvertIntegerArray(String[] strArray) {
		if (null == strArray || 0 == strArray.length)
			return null;
		Integer[] iArray = new Integer[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			iArray[i] = Integer.valueOf(strArray[i]);
		}
		return iArray;
	}

	/**
	 * isJson方法简述
	 * 
	 * <b> 判断传进的json字符串是否为标准的json格式<br>
	 * </b>
	 * 
	 * @param json
	 *            json字符串
	 * @return
	 */
	public static boolean isJson(String json) {
		if (StringUtils.isEmpty(json)) {
			return false;
		}
		try {
			JsonParser parser = new JsonParser();
			JsonElement jsonElement = parser.parse(json);
			return jsonElement.isJsonObject();
		} catch (JsonParseException e) {
			return false;
		}
	}

	/**
	 * dateConvertStr方法简述
	 * 
	 * <p>
	 * 将日期转换固定格式的字符串
	 * </p>
	 * 
	 * @param format
	 *            转换格式
	 * @param date
	 *            日期
	 * @return 返回转换后的日期字符串
	 */
	public static String dateConvertStr(String format, Date date) {
		dateFormat.applyPattern(format);
		return dateFormat.format(date);
	}

	/**
	 * createJsonString 方法简述
	 * 
	 * <p>
	 * 创建一个json对象的字符串
	 * </p>
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static String createJsonString(String key, Object value) {
		JsonObject jsonObject = new JsonObject();
		if (value instanceof Boolean)
			jsonObject.addProperty(key, value.toString());
		else if (value instanceof Number)
			jsonObject.addProperty(key, (Number) value);
		else
			jsonObject.addProperty(key, (String) value);
		return jsonObject.toString();
	}

	public static Date strConvertDate(String format, String dateStr) {
		dateFormat.applyPattern(format);
		try {
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * @param draw
	 *            访问数据次数
	 * @param start
	 *            数据展示开始位置
	 * @param length
	 *            数据展示长度
	 * @param recordsTotal
	 *            总数据数量
	 * @param recordsFiltered
	 *            过滤后的总数
	 * @param mapList
	 *            数据源
	 * @return
	 */
	public static DataTableObject getDTOByMap(Integer draw, Integer start,
			Integer length, Integer recordsTotal, Integer recordsFiltered,
			List<?> mapList) {
		DataTableObject dataTableObject = new DataTableObject();
		dataTableObject.setDraw(draw);
		dataTableObject.setStart(start);
		dataTableObject.setLength(length);
		dataTableObject.setRecordsTotal(recordsTotal);
		dataTableObject.setRecordsFiltered(recordsFiltered);
		dataTableObject.setData(mapList);
		return dataTableObject;
	}
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	public static long getVersion() {
		return System.currentTimeMillis();
	}
}
