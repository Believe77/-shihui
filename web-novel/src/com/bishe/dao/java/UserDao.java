package com.bishe.dao.java;

import org.apache.ibatis.annotations.Param;

import com.bishe.pojo.User;
import com.bishe.pojo.h_user;

public interface UserDao {

	void addUser(User user);

	User findUserByNameAndPwd(@Param("name")String name, @Param("password")String password);

	User findUser(User user);

	User findByName(String name);

	h_user findUser(h_user user);

	h_user findHuser(h_user user);

}
