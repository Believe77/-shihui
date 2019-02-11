package com.meizhuo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="foods")
public class Foods {

	@Id
	@Column(name = "food_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer food_id;
	@Column(name = "window_id")
	private String window_id;
	@Column(name = "food_name")
	private String food_name;
	@Column(name = "food_path")
	private String food_path;
	@Column(name = "food_price")
	private String food_price;
	@Column(name = "food_count")
	private Integer food_count;
	@Column(name = "shop_phone")
	private String shop_phone;
	@Column(name = "shop_address")
	private String shop_address;
	@Column(name = "window_name")
	private String window_name;
	
	
	public String getWindow_name() {
		return window_name;
	}
	public void setWindow_name(String window_name) {
		this.window_name = window_name;
	}
	public Integer getFood_id() {
		return food_id;
	}
	public void setFood_id(Integer food_id) {
		this.food_id = food_id;
	}
	public String getWindow_id() {
		return window_id;
	}
	public void setWindow_id(String window_id) {
		this.window_id = window_id;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getFood_path() {
		return food_path;
	}
	public void setFood_path(String food_path) {
		this.food_path = food_path;
	}
	public String getFood_price() {
		return food_price;
	}
	public void setFood_price(String food_price) {
		this.food_price = food_price;
	}
	public String getShop_phone() {
		return shop_phone;
	}
	public void setShop_phone(String shop_phone) {
		this.shop_phone = shop_phone;
	}
	public String getShop_address() {
		return shop_address;
	}
	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}	
	public Integer getFood_count() {
		return food_count;
	}
	public void setFood_count(Integer food_count) {
		this.food_count = food_count;
	}
	@Override
	public String toString() {
		return "Foods [food_id=" + food_id + ", window_id=" + window_id + ", food_name=" + food_name + ", food_path="
				+ food_path + ", food_price=" + food_price + ", food_count=" + food_count + ", shop_phone=" + shop_phone
				+ ", shop_address=" + shop_address + ", window_name=" + window_name + "]";
	}
	
	
	
	
	
}
