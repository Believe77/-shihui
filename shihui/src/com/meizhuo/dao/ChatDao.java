package com.meizhuo.dao;

import java.util.List;

import com.meizhuo.pojo.Chat;

public interface ChatDao {

	void save(Chat c);

	List<Chat> find();

}
