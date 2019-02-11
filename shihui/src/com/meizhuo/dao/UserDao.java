package com.meizhuo.dao;

import com.meizhuo.pojo.User;

public interface UserDao {
	

	User getByUserCode(String usercode);
	
	void save(User u);
}
