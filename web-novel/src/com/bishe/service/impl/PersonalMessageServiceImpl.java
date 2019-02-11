package com.bishe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.dao.java.PersonalMessageDao;
import com.bishe.pojo.NovelType;
import com.bishe.pojo.PersonalImage;
import com.bishe.pojo.User;
import com.bishe.service.PersonalMessageService;

@Service
public class PersonalMessageServiceImpl implements PersonalMessageService {

	@Autowired
	private PersonalMessageDao personalMessageDao;
	
	public void saveMessage(User user) {
		
		personalMessageDao.saveMessage(user);
		

	}

	public User findPerMessage(Integer id) {
		System.out.println(id);
		return personalMessageDao.findMessage(id);
	}

	public void savePath(String realpath, Integer id1) {
		
		personalMessageDao.savePath(realpath,id1);
		
	}

	public List<PersonalImage> getImage() {
		// TODO Auto-generated method stub
		return personalMessageDao.getImage();
	}

	

	public List<NovelType> findMessage(String name) {
		// TODO Auto-generated method stub
		return personalMessageDao.find(name);
	}

	public void upload2(String path, String name, String author, String type, String style, String message) {
		// TODO Auto-generated method stub
		personalMessageDao.upload2(path,name,author,type,style,message);
	}

	

}
