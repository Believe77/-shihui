package com.meizhuo.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meizhuo.dao.UserPictureDao;
import com.meizhuo.pojo.User;
import com.meizhuo.service.UserPictureService;

@Service
@Transactional
public class UserPictureServiceImpl implements UserPictureService{

	@Resource
	private UserPictureDao userPictureDao;

	@Override
	public void save(String path, User u2) {
		
		userPictureDao.save(path,u2);
	}
	
	
}
