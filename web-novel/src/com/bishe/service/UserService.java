package com.bishe.service;

import com.bishe.pojo.User;
import com.bishe.pojo.h_user;

public interface UserService {

	void regist(User user);

	User login(String name, String password);

	User findUser(User user);

	User findByName(String name);

	h_user findHuser(h_user user);

	

}
