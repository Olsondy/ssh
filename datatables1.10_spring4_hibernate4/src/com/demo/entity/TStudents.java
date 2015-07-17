package com.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * TStudents entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_students", catalog = "demo")
public class TStudents implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1771428858119626428L;
	// Fields
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 学生姓名
	 */
	private String sName;
	/**
	 * 拼音码
	 */
	private String pinyin;
	/**
	 * 学生性别
	 */
	private String sSex;
	/**
	 * 出生日期
	 */
	@DateTimeFormat(iso = ISO.DATE)
	private Date birthday;
	/**
	 * 入学时间
	 */
	@DateTimeFormat(iso = ISO.DATE)
	private Date inDate;
	/**
	 * 说明
	 */
	private String memo;
	/**
	 * 创建时间
	 */
	@DateTimeFormat(style="MM")
	private Date createDate;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 修改时间
	 */
	@DateTimeFormat(iso = ISO.DATE)
	private Date modifyDate;
	/**
	 * 修改者
	 */

	private String modifyUser;
	/**
	 * 状态
	 */
	private String active;
	/**
	 * 班级信息
	 */
	private TClasses classes;

	/** default constructor */
	public TStudents() {
	}

	/** minimal constructor */
	public TStudents(String id) {
		this.id = id;
	}

	/** full constructor */
	public TStudents(String id, String sName, String sSex, Date birthday,
			Date inDate, String memo, String createUser, Date createDate,
			String modifyUser, Date modifyDate, String active) {
		this.id = id;
		this.sName = sName;
		this.sSex = sSex;
		this.birthday = birthday;
		this.inDate = inDate;
		this.memo = memo;
		this.createUser = createUser;
		this.createDate = createDate;
		this.modifyUser = modifyUser;
		this.modifyDate = modifyDate;
		this.active = active;
	}

	// Property accessors
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	@Column(name = "s_name", length = 10)
	public String getsName() {
		return this.sName;
	}

	@Column(name = "pinyin", length = 10)
	public String getPinyin() {
		return pinyin;
	}

	@Column(name = "s_sex", length = 1)
	public String getsSex() {
		return this.sSex;
	}

	@Column(name = "birthday")
	public Date getBirthday() {
		return this.birthday;
	}

	@Column(name = "in_date", length = 0)
	public Date getInDate() {
		return this.inDate;
	}

	@Column(name = "memo", length = 255)
	public String getMemo() {
		return memo;
	}

	@Column(name = "create_date", length = 0)
	public Date getCreateDate() {
		return this.createDate;
	}

	@Column(name = "create_user", length = 50)
	public String getCreateUser() {
		return this.createUser;
	}

	@Column(name = "modify_date", length = 0)
	public Date getModifyDate() {
		return this.modifyDate;
	}

	@Column(name = "modify_user", length = 50)
	public String getModifyUser() {
		return this.modifyUser;
	}

	@Column(name = "active", length = 1)
	public String getActive() {
		return this.active;
	}

	@ManyToOne
	@JoinColumn(name = "c_id", referencedColumnName = "id")
	public TClasses getClasses() {
		return classes;
	}

	public void setActive(String active) {
		this.active = "Y";
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setClasses(TClasses classes) {
		this.classes = classes;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = new Date();
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public void setsSex(String sSex) {
		this.sSex = sSex;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

}