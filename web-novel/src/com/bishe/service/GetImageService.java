package com.bishe.service;

import java.util.List;

import com.bishe.pojo.TopImage;
import com.bishe.pojo.User;
import com.bishe.pojo.h_comment;
import com.bishe.pojo.h_user;

public interface GetImageService {

	List<TopImage> find();

	List<User> getUserMessage();

	List<User> getUserCommon();

	void handle(String name, String chuli);

	void forbidden(String name, String chuli);

	List<h_user> returnForbidden();

	Integer findNumber(String name);

	void saveNumber(Integer forbiddenNumber, String name);

	List<h_comment> getComment(String title);

	void mix(String chuli, String name, String date);

	

}
