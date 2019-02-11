package com.bishe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.dao.java.GetTypeBookDao;
import com.bishe.pojo.NovelType;
import com.bishe.pojo.h_content;
import com.bishe.pojo.h_title;
import com.bishe.service.GetTypeBookService;

@Service
public class GetTypeBookServiceImpl implements GetTypeBookService {

	@Autowired 
	private GetTypeBookDao getTypeBookDao;
	
	
	public List<NovelType> findBookType(String type) {
		
		return getTypeBookDao.findBookType(type);
	}


	public void deletebook(Integer id) {
		
		getTypeBookDao.deletebook(id);
	}


	public List<h_title> getTitle(Integer id) {
		// TODO Auto-generated method stub
		return getTypeBookDao.getTitle(id);
	}


	public List<h_content> getContent(String title) {
		// TODO Auto-generated method stub
		return getTypeBookDao.getContent(title);
	}


	public void saveContent(String title, String content) {
		// TODO Auto-generated method stub
		getTypeBookDao.saveContent(title,content);
	}


	public void saveTitle(Integer id1, String title) {
		// TODO Auto-generated method stub
		getTypeBookDao.saveTitle(id1,title);
	}

}
