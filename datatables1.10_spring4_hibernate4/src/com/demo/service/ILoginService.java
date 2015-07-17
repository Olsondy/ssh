/*
 * All rights Reserved, Designed By DINGYONG
 * Copyright: Copyright(C) 2015
 */
package com.demo.service;


/**
 * @author DINGYONG
 *
 * 2015年7月14日
 */
public interface ILoginService {

	/**
	 * finUser 方法简述
	 * 
	 * <p>
	 * 根据登录名和密码判断是否存在该用户
	 * </p>
	 * 
	 * @param loginName
	 *            登录名
	 * @param LoginPassword
	 *            登录密码
	 * @return
	 */
	public Object finUser(String loginName, String LoginPassword);

}
