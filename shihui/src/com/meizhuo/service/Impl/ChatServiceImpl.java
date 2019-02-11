package com.meizhuo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meizhuo.dao.ChatDao;
import com.meizhuo.pojo.Chat;
import com.meizhuo.service.ChatService;

@Service
@Transactional
public class ChatServiceImpl implements ChatService{

	@Resource
	private ChatDao chatDao;

	@Override
	public void save(Chat c) {
		
		chatDao.save(c);
	}

	@Override
	public List<Chat> find() {
		
		return chatDao.find();
	}
	
	
	
}
