package com.bishe.service;

import java.util.List;

import com.bishe.pojo.NovelType;
import com.bishe.pojo.PersonalImage;
import com.bishe.pojo.User;

public interface PersonalMessageService {

	void saveMessage(User user);//保存用户信息

	User findPerMessage(Integer id);

	void savePath(String realpath, Integer id1);

	List<PersonalImage> getImage();

	
	List<NovelType> findMessage(String name);

	void upload2(String path, String name, String author, String type, String style, String message);

}
