package com.dyi.hibernate.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class User {
	private String f_id;

	private String f_uid;

	private String f_pwd;

	private Date f_reg_date;

	private String f_email;

	private String f_phone;

	private int f_age;

	private int f_gender;

	private String f_address;

	private int f_exist;
	
	public User(){}

	public String getF_id() {
		return f_id;
	}

	public void setF_id(String f_id) {
		this.f_id = f_id;
	}

	public String getF_uid() {
		return f_uid;
	}

	public void setF_uid(String f_uid) {
		this.f_uid = f_uid;
	}

	public String getF_pwd() {
		return f_pwd;
	}

	public void setF_pwd(String f_pwd) {
		this.f_pwd = f_pwd;
	}

	public Date getF_reg_date() {
		return f_reg_date;
	}

	public void setF_reg_date(Date f_reg_date) {
		this.f_reg_date = f_reg_date;
	}

	public String getF_email() {
		return f_email;
	}

	public void setF_email(String f_email) {
		this.f_email = f_email;
	}

	public String getF_phone() {
		return f_phone;
	}

	public void setF_phone(String f_phone) {
		this.f_phone = f_phone;
	}

	public int getF_age() {
		return f_age;
	}

	public void setF_age(int f_age) {
		this.f_age = f_age;
	}

	public int getF_gender() {
		return f_gender;
	}

	public void setF_gender(int f_gender) {
		this.f_gender = f_gender;
	}

	public String getF_address() {
		return f_address;
	}

	public void setF_address(String f_address) {
		this.f_address = f_address;
	}

	public int getF_exist() {
		return f_exist;
	}

	public void setF_exist(int f_exist) {
		this.f_exist = f_exist;
	}
	
	

}
