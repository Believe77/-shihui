package com.meizhuo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bill")
public class Zhangdang {

	@Id
	@Column(name = "zhang_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer zhang_id;
	@Column(name = "zhang_user")
	private String zhang_user;
	@Column(name = "zhang_food")
	private String zhang_food;
	@Column(name = "zhang_price")
	private String zhang_price;
	@Column(name = "zhang_count")
	private String zhang_count;
	@Column(name = "zhang_state")
	private String zhang_state;
	@Column(name = "window_id")
	private String window_id;
	
	public Integer getZhang_id() {
		return zhang_id;
	}
	public void setZhang_id(Integer zhang_id) {
		this.zhang_id = zhang_id;
	}
	public String getZhang_user() {
		return zhang_user;
	}
	public void setZhang_user(String zhang_user) {
		this.zhang_user = zhang_user;
	}
	public String getZhang_food() {
		return zhang_food;
	}
	public void setZhang_food(String zhang_food) {
		this.zhang_food = zhang_food;
	}
	public String getZhang_price() {
		return zhang_price;
	}
	public void setZhang_price(String zhang_price) {
		this.zhang_price = zhang_price;
	}
	public String getZhang_count() {
		return zhang_count;
	}
	public void setZhang_count(String zhang_count) {
		this.zhang_count = zhang_count;
	}
	public String getZhang_state() {
		return zhang_state;
	}
	public void setZhang_state(String zhang_state) {
		this.zhang_state = zhang_state;
	}
	public String getWindow_id() {
		return window_id;
	}
	public void setWindow_id(String window_id) {
		this.window_id = window_id;
	}
	@Override
	public String toString() {
		return "Zhangdang [zhang_id=" + zhang_id + ", zhang_user=" + zhang_user + ", zhang_food=" + zhang_food
				+ ", zhang_price=" + zhang_price + ", zhang_count=" + zhang_count + ", zhang_state=" + zhang_state
				+ ", window_id=" + window_id + "]";
	}
	
	
	
	
}
