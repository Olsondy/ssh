/*
 * All rights Reserved, Designed By DINGYONG
 * Copyright: Copyright(C) 2015
 */
package com.demo.service;

import java.util.List;

/**
 * @author DINGYONG
 *
 *         2015年7月12日
 */
public interface ICommonService {
	/**
	 * 模糊查询自动补全功能
	 * 
	 * @param clazz
	 *            java类
	 * @param field
	 *            属性
	 * @param value
	 *            值
	 * @param num
	 *            数量
	 * @return
	 * @author Dy 2015年7月12日上午6:27:07
	 */
	public List<?> findFieldValue(Class<?> clazz, String field, String value,
			Integer num);
	/**
	 * 公共下拉选择查询(字典使用)
	 * 
	 * @param className
	 *            表名
	 * @param field
	 *            查询出的值
	 * @return
	 * @author Dy 2015年7月12日上午6:10:27
	 */
	public List<?> findDictionaryValue(String className, String field);
}
