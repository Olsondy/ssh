/*
 * All rights Reserved, Designed By DINGYONG
 * Copyright: Copyright(C) 2015
 */
package com.demo.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.service.ICommonService;
import com.demo.util.ClassEnum;
import com.demo.util.Utils;

/**
 * @author DINGYONG
 *
 *         2015年7月12日
 */
@Controller
@RequestMapping("/commonMgt")
public class CommonController {
	@Resource
	ICommonService icommonservice;

	/**
	 * 自动补全模糊查找
	 * 
	 * @param clazzKey
	 *            查找的java类
	 * @param field
	 *            属性
	 * @param value
	 *            值
	 * @param num
	 *            数量
	 * @return
	 * @author Dy 2015年7月12日上午6:46:03
	 */
	@RequestMapping(value = "/showFieldDatas", method = RequestMethod.GET)
	public @ResponseBody String showFieldDatas(@RequestParam String clazzKey,
			@RequestParam String field, @RequestParam String value,
			@RequestParam Integer num) {
		Class<?> clazz = Enum.valueOf(ClassEnum.class, clazzKey).getClazz();
		return Utils.getGson().toJson(icommonservice.findFieldValue(clazz, field, value, num));
	}
}
