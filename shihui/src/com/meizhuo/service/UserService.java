package com.meizhuo.service;

import com.meizhuo.pojo.User;

public interface UserService {
	
	User getUserByCodePassword(User u);
	
	void saveUser(User u);
}
