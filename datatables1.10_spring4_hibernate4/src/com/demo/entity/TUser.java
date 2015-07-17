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
 * TUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_user", catalog = "demo")
public class TUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8300888969380535967L;
	private String id;
	private String loginName;
	private String loginPwd;
	private String userName;
	private String createUser;
	private Date createDate;
	private String modifyUser;
	private Date modifyDate;
	private String active;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(String id) {
		this.id = id;
	}

	/** full constructor */
	public TUser(String id, String loginName, String loginPwd, String userName,
			String createUser, Date createDate, String modifyUser,
			Date modifyDate, String active) {
		this.id = id;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.userName = userName;
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

	@Column(name = "login_name", length = 10)
	public String getLoginName() {
		return loginName;
	}

	@Column(name = "login_pwd", length = 30)
	public String getLoginPwd() {
		return loginPwd;
	}

	@Column(name = "user_name", length = 30)
	public String getUserName() {
		return userName;
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

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}