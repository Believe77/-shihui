package com.meizhuo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="collection")
public class Collection {

	@Id
	@Column(name = "col_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer col_id;
	
	@Column(name = "col_name")
	private String col_name;
	
	@Column(name = "col_path")
	private String col_path;
	
	@Column(name = "col_adress")
	private String col_adress;

	public Integer getCol_id() {
		return col_id;
	}

	public void setCol_id(Integer col_id) {
		this.col_id = col_id;
	}

	public String getCol_name() {
		return col_name;
	}

	public void setCol_name(String col_name) {
		this.col_name = col_name;
	}

	public String getCol_path() {
		return col_path;
	}

	public void setCol_path(String col_path) {
		this.col_path = col_path;
	}

	public String getCol_adress() {
		return col_adress;
	}

	public void setCol_adress(String col_adress) {
		this.col_adress = col_adress;
	}
	
	
	
}
