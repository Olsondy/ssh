/*
 * All rights Reserved, Designed By DINGYONG
 * Copyright: Copyright(C) 2015
 */
package com.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.IBaseDao;
import com.demo.service.ILoginService;

/**
 * @author DINGYONG
 *
 * 2015年7月14日
 */
@Service("loginService")
public class LoginServiceImpl implements ILoginService {

	@Resource
	private IBaseDao baseDao;

	@Override
	@Transactional(readOnly = true)
	public Object finUser(String loginName, String loginPassword) {
		Map<String,Object> map = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer();
		hql.append(" from TUser s where s.loginName =:loginName and s.loginPwd =:loginPassword");
		map.put("loginName", loginName);
		map.put("loginPassword", loginPassword);
		return baseDao.findEntityByHqlReturnMap(hql.toString(), map);
	}

}
