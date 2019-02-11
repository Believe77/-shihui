package com.meizhuo.dao;

import java.util.List;

import com.meizhuo.pojo.Zhangdang;

public interface ReturnBillDao {

	List<Zhangdang> find(String user);

}
