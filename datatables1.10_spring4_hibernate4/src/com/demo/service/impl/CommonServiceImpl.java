/*
 * All rights Reserved, Designed By DINGYONG
 * Copyright: Copyright(C) 2015
 */
package com.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.IBaseDao;
import com.demo.entity.TClasses;
import com.demo.service.ICommonService;

/**
 * @author DINGYONG
 *
 *         2015年7月12日
 */
@Service("icommonservice")
public class CommonServiceImpl implements ICommonService {
	@Resource
	IBaseDao baseDao;


	@Override
	@Transactional(readOnly = true)
	public List<?> findFieldValue(Class<?> clazz, String field, String value,
			Integer num) {
		StringBuffer hql = new StringBuffer();
		hql.append("select new map(id as id," + field + " as cName) from "
				+ clazz.getSimpleName() + " where " + field + " like '%"
				+ value + "%' ");
		List<?> list = baseDao.criteriaFindFieldValue(TClasses.class, field, value, num);
		//baseDao.findDatasByEntity(hql.toString(), TClasses.class, 0, 0);
		//baseDao.criteriaFindFieldValue(TClasses.class, field, value, num);
		return list;
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<?> findDictionaryValue(String tableName, String field) {
		return null;
	}
}
