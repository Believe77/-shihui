package com.bishe.dao.java;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bishe.pojo.TopImage;
import com.bishe.pojo.User;
import com.bishe.pojo.h_comment;
import com.bishe.pojo.h_user;

public interface GetImageDao {

	List<TopImage> find();

	List<User> getUserMessage();

	List<User> getUserCommon();

	Object handle(@Param("name")String name, @Param("manger")String chuli);

	void forbidden(@Param("name")String name,@Param("forbidden") String chuli);

	List<h_user> returnForbidden();

	Integer findNumber(String name);

	void saveNumber(@Param("forbiddenNumber")Integer forbiddenNumber,@Param("name")String name);

	List<h_comment> getComment(String title);

	void mix(@Param("zhuangtai")String chuli,@Param("username")String name,@Param("date")String date);

	
}
