package com.bishe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.dao.java.GetImageDao;
import com.bishe.pojo.TopImage;
import com.bishe.pojo.User;
import com.bishe.pojo.h_comment;
import com.bishe.pojo.h_user;
import com.bishe.service.GetImageService;

@Service
public class GetImageServiceImpl implements GetImageService {

	@Autowired
	private GetImageDao getImageDao;
	
	public List<TopImage> find(){
		
		return getImageDao.find();
	}

	public List<User> getUserMessage() {
		// TODO Auto-generated method stub
		return getImageDao.getUserMessage();
	}

	public List<User> getUserCommon() {
		// TODO Auto-generated method stub
		return getImageDao.getUserCommon();
	}

	public void handle(String name, String chuli) {
		// TODO Auto-generated method stub
		 getImageDao.handle(name,chuli);
	}

	public void forbidden(String name, String chuli) {
		// TODO Auto-generated method stub
		getImageDao.forbidden(name,chuli);
	}

	public List<h_user> returnForbidden() {
		// TODO Auto-generated method stub
		return getImageDao.returnForbidden();
	}

	public Integer findNumber(String name) {
		// TODO Auto-generated method stub
		return getImageDao.findNumber(name);
	}

	public void saveNumber(Integer forbiddenNumber,String name) {
		// TODO Auto-generated method stub
		getImageDao.saveNumber(forbiddenNumber,name);
	}

	public List<h_comment> getComment(String title) {
		// TODO Auto-generated method stub
		return getImageDao.getComment(title);
	}

	public void mix(String chuli, String name, String date) {
		System.out.println(chuli);
		// TODO Auto-generated method stub
		getImageDao.mix(chuli,name,date);
	}

}
