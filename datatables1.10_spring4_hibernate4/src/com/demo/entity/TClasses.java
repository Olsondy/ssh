package com.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TClasses entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_classes", catalog = "demo")
public class TClasses implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7356554263179723341L;
	/**
	 * 班级主键
	 */
	private String id; 
	/**
	 * 班级名称
	 */
	private String name;   
	/**
	 * 学生总数
	 */
	private String sumStudents;
	/**
	 * 创建者
	 */
	private String createUser;  
	/**
	 * 创建日期
	 */
	private Date createDate;	
	/**
	 * 修改者
	 */
	private String modifyUser;  
	/**
	 * 修改时间
	 */
	private Date modifyDate;	
	/**
	 * 状态
	 */
	private String active;		
	

	// Constructors

	/** default constructor */
	public TClasses() {
	}

	/** minimal constructor */
	public TClasses(String id) {
		this.id = id;
	}

	/** full constructor */
	public TClasses(String id, String name,String sumStudents, String createUser,
			Date createDate, String modifyUser, Date modifyDate, String active) {
		this.id = id;
		this.name = name;
		this.sumStudents = sumStudents;
		this.createUser = createUser;
		this.createDate = createDate;
		this.modifyUser = modifyUser;
		this.modifyDate = modifyDate;
		this.active = active;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "create_user", length = 50)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date", length = 0)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "modify_user", length = 50)
	public String getModifyUser() {
		return this.modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "modify_date", length = 0)
	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Column(name = "active", length = 1)
	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	@Column(name = "sum_students")
	public String getSumStudents() {
		return sumStudents;
	}

	public void setSumStudents(String sumStudents) {
		this.sumStudents = sumStudents;
	}
	
}