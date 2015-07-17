/*
 * All rights Reserved, Designed By DINGYONG
 * Copyright: Copyright(C) 2015
 */
package com.demo.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.demo.dao.IBaseDao;
import com.demo.entity.DataTableObject;
import com.demo.entity.TStudents;
import com.demo.service.IStudentsService;
import com.demo.util.Utils;

/**
 * @author DINGYONG
 *
 *         2015年7月12日
 */
@Service
public class StudentsServiceImpl implements IStudentsService {
	@Resource
	IBaseDao baseDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public TStudents merge(Object entity) {
		return (TStudents) baseDao.mergeEntity(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public DataTableObject findAllStudent(Map<String, Object> maps) {
		StringBuffer sbHql = new StringBuffer();
		sbHql.append(" from TStudents s");
		sbHql.append(" left join s.classes c");
		sbHql.append(" where 1=1 ");
		if (!StringUtils.isEmpty(maps.get("classes.name"))) {
			sbHql.append(" and c.name = :name");
			maps.put("name", maps.get("classes.name"));
		}
		if (!StringUtils.isEmpty(maps.get("sName"))) {
			sbHql.append(" and s.sName like :sName");
			maps.put("sName", "%"+maps.get("sName")+"%");
		}
		if (!StringUtils.isEmpty(maps.get("sSex"))) {
			sbHql.append(" and s.sSex = :sex");
			maps.put("sex", maps.get("sSex"));
		}
		if (!StringUtils.isEmpty(maps.get("inDate"))) {
			// 日期范围
				String[] ruDates = maps.get("inDate").toString().split(" - ");
				Date beginDate = Utils.strConvertDate("yyyy-MM-dd", ruDates[0]);
				Date endDate = Utils.strConvertDate("yyyy-MM-dd", ruDates[1]);
				sbHql.append("and s.inDate <= :endDate and  s.inDate >= :beginDate ");
				maps.put("beginDate", beginDate);
				maps.put("endDate", endDate);
		}
		sbHql.append(" order by s.inDate");
		int count = baseDao.findDataCountsByMap(
				"select count(s.id)" + sbHql.toString(), maps);
		//查询学生信息
		sbHql.insert(0, "select new map(s.id as id," + "s.sName as sName,"
				+ "s.sSex as sex," + "date_format(s.inDate,'%Y-%m-%d') as inDate,"+"date_format(s.birthday,'%Y-%m-%d') as birthday,"
				+ "c.id as cId," + "c.name as name)");
		// 根据分页条件查询相关的数据
		List<?> list = baseDao.findDatasByMap(sbHql.toString(), maps,
				Integer.valueOf(maps.get("start").toString()),
				Integer.valueOf(maps.get("length").toString()));
		// 返回DataTable必须的参数
		DataTableObject dataTableObject = Utils.getDTOByMap(
				Integer.valueOf(maps.get("draw").toString()),
				Integer.valueOf(maps.get("start").toString()),
				Integer.valueOf(maps.get("length").toString()), count, count,
				list);
		return dataTableObject;
	}
	@Override
	@Transactional(readOnly = true)
	public Object findStudentsById(String id) {
		Map<String,Object> map = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer();
		hql.append(" select new map(s.id as id,s.sName as sName,s.sSex as sex,");
		hql.append(" date_format(s.inDate,'%Y-%m-%d') as inDate,");
		hql.append(" date_format(s.birthday,'%Y-%m-%d') as birthday,");
		hql.append(" s.memo as memo ,s.pinyin as pinyin,");
		hql.append(" c.id as cId,c.name as cName)");
		hql.append(" from TStudents s left join s.classes c");
		hql.append(" where s.id =:id");
		map.put("id", id);
		return baseDao.findEntityByHqlReturnMap(hql.toString(),map);
	}
	@Override
	@Transactional(readOnly = true)
	public int checkIsExistByFieldName(Object value) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
