package com.bishe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.dao.java.SaveBookDao;
import com.bishe.pojo.NovelType;
import com.bishe.pojo.Shelf;
import com.bishe.service.SaveBookService;

@Service
public class SaveBookServiceImpl implements SaveBookService {

	@Autowired
	private SaveBookDao saveBookDao;
	
	public NovelType findBook(Integer bid) {
		
		return saveBookDao.findBook(bid);
	}

	public void saveBook(Shelf s) {
		
		saveBookDao.saveBook(s);
		
	}

	public Integer findCount(Integer bid2) {
		// TODO Auto-generated method stub
		return saveBookDao.findCount(bid2);
	}

	

	public void saveCount(Integer cishu, Integer bid2) {
		
		saveBookDao.saveCount(cishu,bid2);
		
	}

	public NovelType find(String bid) {
	
		return saveBookDao.find(bid);
	}

	public String ask(Integer id) {
		// TODO Auto-generated method stub
		return saveBookDao.ask(id);
	}

	

}
