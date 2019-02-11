package com.bishe.dao.java;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bishe.pojo.NovelType;
import com.bishe.pojo.PersonalImage;
import com.bishe.pojo.User;

public interface PersonalMessageDao {


	void saveMessage(User user);

	void savePath(@Param("path")String realpath,@Param("id")Integer id1);

	User findMessage(Integer id);

	List<PersonalImage> getImage();

	List<NovelType> find(String name);

	void upload2(@Param("path")String path,@Param("name")String name, @Param("author")String author,
			@Param("type")String type, @Param("style")String style, @Param("message")String message);

}
