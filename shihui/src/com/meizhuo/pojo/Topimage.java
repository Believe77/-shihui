package com.meizhuo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="topimage")
public class Topimage {

	@Id
	@Column(name = "dict_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dict_id;
	@Column(name = "dict_code")
	private String dict_code;
	@Column(name = "dict_image")
	private String dict_image;
	@Column(name = "dict_message")
	private String dict_message;
	
	
	public Integer getDict_id() {
		return dict_id;
	}
	public void setDict_id(Integer dict_id) {
		this.dict_id = dict_id;
	}
	public String getDict_code() {
		return dict_code;
	}
	public void setDict_code(String dict_code) {
		this.dict_code = dict_code;
	}
	public String getDict_image() {
		return dict_image;
	}
	public void setDict_image(String dict_image) {
		this.dict_image = dict_image;
	}
	public String getDict_message() {
		return dict_message;
	}
	public void setDict_message(String dict_message) {
		this.dict_message = dict_message;
	}
	@Override
	public String toString() {
		return "BaseDict [dict_id=" + dict_id + ", dict_code=" + dict_code + ", dict_image=" + dict_image
				+ ", dict_message=" + dict_message + "]";
	}
	
	
	
	
}
