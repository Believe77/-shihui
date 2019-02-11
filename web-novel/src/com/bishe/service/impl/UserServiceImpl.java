package com.bishe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.dao.java.UserDao;
import com.bishe.pojo.User;
import com.bishe.pojo.h_user;
import com.bishe.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void regist(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}
 
	public User login(String name, String password) {
		// TODO Auto-generated method stub
		  return userDao.findUserByNameAndPwd(name,password);
	}

	public User findUser(User user) {
		// TODO Auto-generated method stub
		return userDao.findUser(user);
	}

	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findByName(name);
	}

	public h_user findHuser(h_user user) {
		// TODO Auto-generated method stub
		return userDao.findHuser(user);
	}

}
