/*
 * All rights Reserved, Designed By DINGYONG
 * Copyright: Copyright(C) 2015
 */
package com.demo.service;

import java.util.Map;

import com.demo.entity.DataTableObject;
import com.demo.entity.TStudents;

/**
 * @author DINGYONG
 *
 *         2015年7月12日
 */

public interface IStudentsService {

	/**
	 * 增加和修改方法
	 * 
	 * merge
	 * 
	 * @param entity
	 *            实体参数
	 * @return
	 * @author Dy 2015年7月12日上午3:11:22
	 */
	public TStudents merge(Object entity);

	/**
	 * 查询所有学生 (按报道时间)
	 * 
	 * findAllStudent
	 * 
	 * @param maps
	 *            前台datatable 和 form的传值
	 * @return
	 * @author Dy 2015年7月12日上午3:19:29
	 */
	public DataTableObject findAllStudent(Map<String, Object> maps);

	/**
	 * 按id查询学生信息
	 * 
	 * @param id
	 *            学生的主键
	 * @return
	 * @author Dy 2015年7月14日上午12:49:22
	 */
	public Object findStudentsById(String id);

	/**
	 * 校验是否存在
	 * 
	 * checkIsExistByFieldName
	 * 
	 * @param value
	 *            校验的值
	 * @return
	 * @author Dy 2015年7月12日下午7:18:09
	 */
	public int checkIsExistByFieldName(Object value);
}
