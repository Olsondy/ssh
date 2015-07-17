package com.demo.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

/**
 * @author DINGYONG
 *
 *         2015年7月12日
 */
public interface IBaseDao {

	public Session getCurrentSession();

	// 基本的公共方法

	/**
	 * mergeEntity方法简述
	 * 
	 * <p>
	 * 如果该实体对象的ID没有值，就会执行保存的操作；若ID存在值，就会执行修改的操作；
	 * </p>
	 * 
	 * @param entity
	 *            实体对象
	 * @return 返回保存或修改后的实体对象
	 */
	public Object mergeEntity(final Object entity);

	/**
	 * deleteByEntityId方法简述
	 * 
	 * <p>
	 * 根据类和主键值，删除单个该对象数据
	 * </p>
	 * 
	 * @param clazz
	 *            对象类
	 * 
	 * @param entityId
	 *            对象类的主键值
	 * 
	 */
	public void deleteByEntityId(final Class<?> clazz, final String entityId);

	/**
	 * deleteByEntityIds方法简述
	 * 
	 * <p>
	 * 根据类和主键值数组，删除符合条件的对象数据<br>
	 * hql:delete from clazz where id in :ids
	 * </p>
	 * 
	 * @param clazz
	 *            要删除对象数据的类
	 * @param ids
	 *            对象类的主键值数组
	 * @return 返回删除数据的的个数
	 */
	public int deleteByEntityIds(final Class<?> clazz, final String[] ids);

	/**
	 * deleteByEntity 方法简述
	 * 
	 * <p>
	 * 根据类，删除符合条件的对象数据 <br>
	 * hql:delete from clazz where xx = :xx or yy = :yy ... <br>
	 * 调用：getCurrentSession().createQuery(hql.toString()).setProperties(entity).
	 * executeUpdate(); <br>
	 * </p>
	 * 
	 * @param hql
	 *            自定义删除的hql语句
	 * @param entity
	 *            条件对象
	 * @return 返回删除的条数
	 */
	public int deleteByEntity(final String hql, final Object entity);

	/**
	 * createSQLUpdateEntity 方法简述
	 * 
	 * <p>
	 * 根据自定义的hql，如update Class set xx = :xx where yy = :yy 修改数据信息
	 * </p>
	 * 
	 * @param hql
	 *            修改的hql语句
	 * @param entity
	 *            条件对象
	 * @return
	 */
	public int updateEntity(final String hql, final Object entity);

	/**
	 * findDataById方法简述
	 * 
	 * <b> 根据对象类和主键值，查询该对象数据 </b>
	 * 
	 * @param clazz
	 *            要获得对象数据的类
	 * @param entityId
	 *            该对象数据的主键值
	 * @return 返回查询后的对象数据
	 */
	public Object findDataById(final Class<?> clazz, final String entityId);

	/**
	 * findDatasByEntity方法简述
	 * 
	 * <p>
	 * 根据传来的hql语句，条件对象，分页条件来查找相关数据<br>
	 * setProperties(entity)<br>
	 * setFirstResult(start)<br>
	 * setMaxResult(length) <br>
	 * </p>
	 * 
	 * @param hql
	 *            自定义的hql语句
	 * @param entity
	 *            条件对象
	 * @param start
	 *            开始的位数
	 * @param length
	 *            返回数据的条数
	 * @return 返回对象集合
	 */
	public List<?> findDatasByEntity(final String hql, final Object entity,
			final Integer start, final Integer length);

	/**
	 * findDatasByMap方法简述
	 * 
	 * note: 条件封装是用map集合
	 * 
	 * <p>
	 * 根据传来的hql语句，条件对象，分页条件来查找相关数据<br>
	 * setProperties(map)<br>
	 * setFirstResult(start)<br>
	 * setMaxResult(length) <br>
	 * </p>
	 * 
	 * @param hql
	 *            自定义的hql语句
	 * @param map
	 *            条件集合
	 * @param start
	 *            开始的位数
	 * @param length
	 *            返回数据的条数
	 * @return 返回对象集合
	 */
	public List<?> findDatasByMap(final String hql,
			final Map<String, Object> map, final Integer start,
			final Integer length);

	/**
	 * findDataCountsByEntity方法简述
	 * 
	 * <p>
	 * 根据传来的hql语句，条件对象来查找相关数据的总记录数<br>
	 * setProperties(entity)<br>
	 * </p>
	 * 
	 * @param hql
	 *            自定义的hql语句
	 * @param entity
	 *            条件对象
	 * @return 返回总个数
	 */
	public int findDataCountsByEntity(final String hql, final Object entity);

	/**
	 * findDataCountsByMap方法简述
	 * 
	 * note: 条件封装是用map集合
	 * 
	 * <p>
	 * 根据传来的hql语句，条件对象来查找相关数据的总记录数<br>
	 * setProperties(map)<br>
	 * </p>
	 * 
	 * @param hql
	 *            自定义的hql语句
	 * @param map
	 *            条件map集合
	 * @return 返回总个数
	 */
	public int findDataCountsByMap(final String hql,
			final Map<String, Object> map);

	/**
	 * findEntityByHql 方法简述
	 * 
	 *根据HQL 查询唯一数据 
	 *
	 * @param hql
	 *            自定义hql
	 * @param clazz
	 *            类
	 * @param id
	 *            主键
	 * @return
	 * @author Dy 2015年7月14日
	 */
	public Object findEntityByHqlReturnMap(String hql,Map<String,Object> map);

	// 特殊扩展

	/**
	 * checkFieldValueIsExist方法简述
	 * 
	 * <p>
	 * 检查某个字段的值在库中是否已经存在了<br>
	 * 形式如下:<br>
	 * hql：select id from Class c where c.xx = :xx <br>
	 * </p>
	 * 
	 * @param hql
	 *            自定义的hql语句
	 * @param fieldName
	 *            属性别名
	 * @param fieldValue
	 *            属性值
	 * @return 返回存在数据的编号
	 */
	public Integer checkFieldValueIsExist(final String hql,
			final String fieldName, final Object fieldValue);

	/**
	 * criteriaFindFieldValue 方法简述
	 * 
	 * <p>
	 * 该方法可配合前台typeahead插件一起使用<br>
	 * 使用hibernate的QBC模糊查询该字段(field)的值
	 * </p>
	 * 
	 * @param clazz
	 *            要查询的类
	 * @param field
	 *            该类的字段
	 * @param value
	 *            该类字段的值
	 * @param num
	 *            查询的个数
	 * @return 返回该类的字段的数组集合
	 */
	public List<?> criteriaFindFieldValue(final Class<?> clazz,
			final String field, final String value, final Integer num);

}
