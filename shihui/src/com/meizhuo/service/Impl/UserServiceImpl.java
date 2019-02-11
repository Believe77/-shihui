package com.meizhuo.service.Impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meizhuo.dao.UserDao;
import com.meizhuo.pojo.User;
import com.meizhuo.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao ud;
	
	public User getUserByCodePassword(User u) {
			
			User existU = ud.getByUserCode(u.getUser_code());
		
			
			
		
		return existU;
	}

	
	public void saveUser(User u) {
		User existU = ud.getByUserCode(u.getUser_code());
		
		ud.save(u);

		}

}
