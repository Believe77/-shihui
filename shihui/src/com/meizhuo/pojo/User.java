package com.meizhuo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	@Column(name = "user_code")
	private String user_code;
	@Column(name = "user_name")
	private String user_name;
	@Column(name = "user_password")
	private String user_password;
	@Column(name = "user_state")
	private Character user_state;
	@Column(name = "user_sex")
	private String user_sex;
	@Column(name = "user_phone")
	private String user_phone;
	@Column(name = "user_address")
	private String user_address;
	@Column(name = "user_path")
	private String user_path;
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public Character getUser_state() {
		return user_state;
	}
	public void setUser_state(Character user_state) {
		this.user_state = user_state;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	
	public String getUser_path() {
		return user_path;
	}
	public void setUser_path(String user_path) {
		this.user_path = user_path;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_code=" + user_code + ", user_name=" + user_name + ", user_password="
				+ user_password + ", user_state=" + user_state + ", user_sex=" + user_sex + ", user_phone=" + user_phone
				+ ", user_address=" + user_address + "]";
	}
	
	
	
}
