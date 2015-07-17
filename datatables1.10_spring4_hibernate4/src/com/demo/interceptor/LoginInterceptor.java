/*
 * All rights Reserved, Designed By DINGYONG
 * Copyright: Copyright(C) 2015
 */
package com.demo.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author DINGYONG
 *
 *         2015年7月8日
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	// 在执行action里面的逻辑后返回视图之前执行
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj, ModelAndView view)
			throws Exception {
	}

	// 在执行controller里面的处理逻辑之前执行
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
		Map<String, Object> map = (Map<String, Object>) request.getSession()
				.getAttribute("CZUser");
		if (StringUtils.isEmpty(map)) {

			if (!StringUtils.isEmpty(request.getHeader("x-requested-with"))
					&& request.getHeader("x-requested-with").equalsIgnoreCase(
							"XMLHttpRequest")) {
				System.out.println("---------------未登录--------------");
				response.setHeader("sessionstatus", "login is timeout");
			} else {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
			return false;
		}
		return true;
	}

}
