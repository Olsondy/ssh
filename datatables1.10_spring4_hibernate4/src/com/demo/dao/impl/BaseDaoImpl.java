/*
 * All rights Reserved, Designed By DINGYONG
 * Copyright: Copyright(C) 2015
 */
package com.demo.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.demo.dao.IBaseDao;
import com.demo.entity.TClasses;

/**
 * @author DINGYONG
 *
 * 2015年7月12日
 */
@Repository("baseDao")
public class BaseDaoImpl implements IBaseDao {
	@Resource
	SessionFactory sessionFactory;
	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Object mergeEntity(Object entity) {
		return getCurrentSession().merge(entity);
	}
	@Override
	public void deleteByEntityId(Class<?> clazz, String entityId) {
		Object object = findDataById(clazz, entityId);
		getCurrentSession().delete(object);
	}

	@Override
	public int deleteByEntityIds(Class<?> clazz, String[] ids) {
		StringBuffer hql = new StringBuffer("delete from ");
		hql.append(clazz.getSimpleName() + " ");
		hql.append("where id in :ids ");
		return getCurrentSession().createQuery(hql.toString())
				.setParameterList("ids", ids).executeUpdate();
	}

	@Override
	public int deleteByEntity(String hql, Object entity) {
		return getCurrentSession().createQuery(hql).setProperties(entity)
				.executeUpdate();
	}
	@Override
	public int updateEntity(String hql, Object entity) {
		Query query = getCurrentSession().createQuery(hql);
		if (!StringUtils.isEmpty(entity))
			query.setProperties(entity);
		return query.executeUpdate();
	}
	@Override
	public Object findDataById(Class<?> clazz, String entityId) {
		return getCurrentSession().get(clazz, entityId);
	}

	@Override
	public List<?> findDatasByEntity(String hql, Object entity, Integer start,
			Integer length) {
		Query query = getCurrentSession().createQuery(hql);
		if (!StringUtils.isEmpty(entity))
			query.setProperties(entity);
		if (!StringUtils.isEmpty(start))
			query.setFirstResult(start);
		if (!StringUtils.isEmpty(length))
			query.setMaxResults(length);
		return query.list();
	}
	@Override
	public List<?> findDatasByMap(String hql, Map<String, Object> map,
			Integer start, Integer length) {
		Query query = getCurrentSession().createQuery(hql);
		if (!StringUtils.isEmpty(map))
			query.setProperties(map);
		if (!StringUtils.isEmpty(start))
			query.setFirstResult(start);
		if (!StringUtils.isEmpty(length))
			query.setMaxResults(length);
		return query.list();
	}

	@Override
	public int findDataCountsByEntity(String hql, Object entity) {
		Query query = getCurrentSession().createQuery(hql);
		if (!StringUtils.isEmpty(entity))
			query.setProperties(entity);
		return Integer.valueOf(query.uniqueResult().toString());
	}

	@Override
	public int findDataCountsByMap(String hql, Map<String, Object> map) {
		Query query = getCurrentSession().createQuery(hql);
		if (!StringUtils.isEmpty(map))
			query.setProperties(map);
		return Integer.valueOf(query.uniqueResult().toString());
	}

	@Override
	public Integer checkFieldValueIsExist(String hql, String fieldName,
			Object fieldValue) {
		if (StringUtils.isEmpty(fieldValue) || StringUtils.isEmpty(fieldValue))
			return null;

		Object obj = getCurrentSession().createQuery(hql)
				.setParameter(fieldName, fieldValue).uniqueResult();
		if (StringUtils.isEmpty(obj))
			return null;
		return (int) obj;
	}

	@Override
	public List<?> criteriaFindFieldValue(Class<?> clazz, String field,
			String value, Integer num) {
		// QBC查询id,name
		Criteria criteria = getCurrentSession()
				.createCriteria(clazz)
				.setProjection(
						Projections.projectionList().add(
								Projections.property(field),"name").add(Projections.id(),"id"))
				.add(Restrictions.like(field, "%" + value + "%"));
		criteria.setResultTransformer(Transformers.aliasToBean(TClasses.class));
		if (!StringUtils.isEmpty(num))
			return criteria.setFirstResult(0).setMaxResults(num).list();
		return criteria.list();
	}

	@Override
	public Object findEntityByHqlReturnMap(String hql, Map<String,Object> map) {
		Query query = getCurrentSession().createQuery(hql);
		if (!StringUtils.isEmpty(map)){
			query.setProperties(map);
		}
		return query.uniqueResult();
	}

}
