package com.meizhuo.service;

import java.util.List;

import com.meizhuo.pojo.Chat;

public interface ChatService {

	void save(Chat c);

	List<Chat> find();

}
