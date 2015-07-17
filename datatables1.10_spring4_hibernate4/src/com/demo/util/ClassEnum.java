/*
 * All rights Reserved, Designed By DINGYONG
 * Copyright: Copyright(C) 2015
 */
package com.demo.util;

import com.demo.entity.TClasses;
import com.demo.entity.TStudents;
import com.demo.entity.TUser;


/**
 * @author DINGYONG
 *
 * 2015年7月11日
 */
public enum ClassEnum {
	TUSER(TUser.class),
	TCLASSES(TClasses.class),
	TSTUDENTS(TStudents.class);
	/**
	 * @param clazz
	 */
	ClassEnum(Class<?> clazz) {
		this.clazz = clazz;
	}

	private final Class<?> clazz;

	public Class<?> getClazz() {
		return clazz;
	}
}
