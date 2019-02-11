package com.meizhuo.service.Impl;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meizhuo.dao.PersonalMessageDao;
import com.meizhuo.pojo.User;
import com.meizhuo.service.PersonalMessageService;

@Service
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class PersonalMessageServiceImpl implements PersonalMessageService {

	@Resource
	private PersonalMessageDao personalMessageDao;
	
	

	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(User user) throws SQLException {
		
		 personalMessageDao.save(user);

	}

}
