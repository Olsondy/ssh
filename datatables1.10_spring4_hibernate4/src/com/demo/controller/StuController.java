/*
 * All rights Reserved, Designed By DINGYONG
 * Copyright: Copyright(C) 2015
 */
package com.demo.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.DataTableObject;
import com.demo.entity.TStudents;
import com.demo.entity.TUser;
import com.demo.service.IStudentsService;
import com.demo.util.Utils;

/**
 * @author DINGYONG
 *
 *         2015年7月12日
 */
@Controller
@RequestMapping("/studentsMgt")
public class StuController {
	@Resource
	IStudentsService IStu;
	@Resource
	private HttpServletRequest request;

	@RequestMapping(value = "/mergeStu", method = RequestMethod.POST)
	public @ResponseBody String mergeStu(TStudents stu) {
		TUser user = (TUser) request.getSession().getAttribute("DYUser");
		if (!StringUtils.isEmpty(stu.getId()))
		stu.setModifyUser(user.getId());
		stu.setModifyDate(new Date());
		stu = IStu.merge(stu);
		return Utils.createJsonString("id", stu.getId());
	}

	/**
	 * 查询所有学生
	 * 
	 * findAllStudents
	 * 
	 * @param maps
	 * @return
	 * @author Dy 2015年7月12日
	 */
	@RequestMapping(value = "/findAllStu", method = RequestMethod.GET)
	public @ResponseBody String findAllStudents(
			@RequestParam Map<String, Object> maps) {
		DataTableObject datatableobject = IStu.findAllStudent(maps);
		return Utils.getGson().toJson(datatableobject);
	}

	/**
	 * 按id查询学生信息
	 * 
	 * @param id
	 * @return
	 * @author Dy 2015年7月14日
	 */
	@RequestMapping(value = "/findStuById/{sid}", method = RequestMethod.GET)
	public @ResponseBody String findStuById(@PathVariable String sid) {
		return Utils.getGson().toJson(IStu.findStudentsById(sid));
	}

	/**
	 * 获取拼音码
	 * 
	 * getPinyinByName
	 * 
	 * @param name
	 * @return String
	 * @author Dy
	 */
	@RequestMapping(value = "/getPinyin", method = RequestMethod.GET)
	public @ResponseBody String getPinyinByName(@RequestParam String name) {
		// 实例化拼音格式
		HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
		// 设置转换格式为字母小写
		outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		// 组合名称
		StringBuffer sbName = new StringBuffer();
		// 将多个汉字转换为字符数组
		char[] nameChars = name.trim().toCharArray();
		if (!StringUtils.isEmpty(name) && nameChars.length > 0) {
			for (int i = 0; i < nameChars.length; i++) {
				if (name.charAt(i) <= 'z' || name.charAt(i) <= 'Z') {
					sbName.append(nameChars[i]);
				} else {
					try {
						String[] stringName = PinyinHelper
								.toHanyuPinyinStringArray(nameChars[i],
										outputFormat);
						sbName.append(stringName[i]);
					} catch (BadHanyuPinyinOutputFormatCombination e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return sbName.toString();
	}
}
