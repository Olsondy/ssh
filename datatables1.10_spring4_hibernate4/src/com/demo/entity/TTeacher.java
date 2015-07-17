package com.demo.entity;

// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TTeacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_teacher", catalog = "demo")
public class TTeacher implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2392653062209164174L;
	private String id;
	private String name;
	private String pinyin;
	private String sex;
	private String telephone;
	private String address;
	private String isHead;
	private String createUser;
	private Date createDate;
	private String modifyUser;
	private Date modifyDate;
	private String active;

	// Constructors

	/** default constructor */
	public TTeacher() {
	}

	/** minimal constructor */
	public TTeacher(String id) {
		this.id = id;
	}

	/** full constructor */
	public TTeacher(String id, String name, String pinyin, String sex,
			String telephone, String address, String isHead, String createUser,
			Date createDate, String modifyUser, Date modifyDate, String active) {
		this.id = id;
		this.name = name;
		this.pinyin = pinyin;
		this.sex = sex;
		this.telephone = telephone;
		this.address = address;
		this.isHead = isHead;
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

	@Column(name = "name", length = 10)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pinyin", length = 10)
	public String getPinyin() {
		return this.pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	@Column(name = "sex", length = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "telephone", length = 11)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "address", length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "is_head", length = 1)
	public String getIsHead() {
		return this.isHead;
	}

	public void setIsHead(String isHead) {
		this.isHead = isHead;
	}

	@Column(name = "create_user", length = 10)
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

	@Column(name = "modify_user", length = 10)
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

}