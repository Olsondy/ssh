/*
 * All rights Reserved, Designed By DINGYONG
 * Copyright: Copyright(C) 2015
 */
package com.demo.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.TUser;
import com.demo.service.ILoginService;
import com.demo.util.Utils;


/**
 * @author DINGYONG
 *
 * 2015年7月14日
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Resource
	private ILoginService loginService;

	@Resource
	private HttpServletRequest request;

	/**
	 * 根据登录名和密码确认是否存在
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/loginValidate", method = RequestMethod.GET)
	public @ResponseBody String findEmployeeByLoginNameAndPassword(
			@RequestParam String username, @RequestParam String password) {
		TUser user = (TUser) loginService.finUser(username, password);
		if (StringUtils.isEmpty(user)) {
			return Utils.createJsonString("status", "0");
		}
		// 用户保存在Session域中
		HttpSession session = request.getSession();
		session.setAttribute("DYUser", user);
		// 设置失效时间 15分钟
		//session.setMaxInactiveInterval(900);
		return Utils.createJsonString("status", "1");
	}

	/**
	 * 注销
	 * 
	 * @return
	 */
	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public @ResponseBody String exit() {
		request.getSession().removeAttribute("DYUser");
		return Utils.createJsonString("success", "0");
	}

}
