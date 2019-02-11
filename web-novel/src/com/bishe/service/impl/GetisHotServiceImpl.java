package com.bishe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.dao.java.GetisHotDao;
import com.bishe.pojo.Hot;
import com.bishe.pojo.h_book;
import com.bishe.pojo.h_type;
import com.bishe.service.GetisHotService;

@Service
public class GetisHotServiceImpl implements GetisHotService {

	@Autowired 
	private GetisHotDao getisHotDao;
	
	
	public List<Hot> findIsHot(String id) {
		// TODO Auto-generated method stub
		return getisHotDao.findIsHot(id);
	}

	

	public List<h_type> findtype() {
		// TODO Auto-generated method stub
		return getisHotDao.findtype();
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getisHotDao.delete(id);
	}

	public void add(String type) {
		// TODO Auto-generated method stub
		getisHotDao.add(type);
	}

	public List<h_book> findTypebook(String type) {
		// TODO Auto-generated method stub
		return getisHotDao.findTypebook(type);
	}

}
