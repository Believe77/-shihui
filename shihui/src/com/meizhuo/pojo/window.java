package com.meizhuo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CanteenWindow")
public class window {
	
	@Id
	@Column(name = "window_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer window_id;
	
	@Column(name = "carteen_id")
	private String carteen_id;
	
	@Column(name = "window_name")
	private String window_name;
	
	@Column(name = "window_path")
	private String window_path;
	
	@Column(name = "window_address")
	private String window_address;
	
	
	
	
	
	
	
	public Integer getWindow_id() {
		return window_id;
	}
	public void setWindow_id(Integer window_id) {
		this.window_id = window_id;
	}
	public String getCarteen_id() {
		return carteen_id;
	}
	public void setCarteen_id(String carteen_id) {
		this.carteen_id = carteen_id;
	}
	public String getWindow_name() {
		return window_name;
	}
	public void setWindow_name(String window_name) {
		this.window_name = window_name;
	}
	public String getWindow_path() {
		return window_path;
	}
	public void setWindow_path(String window_path) {
		this.window_path = window_path;
	}
	public String getWindow_address() {
		return window_address;
	}
	public void setWindow_address(String window_address) {
		this.window_address = window_address;
	}
	
	
	

	
}
