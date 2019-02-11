package com.bishe.dao.java;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bishe.pojo.NovelType;
import com.bishe.pojo.h_content;
import com.bishe.pojo.h_title;

public interface GetTypeBookDao {

	List<NovelType> findBookType(String type);

	void deletebook(@Param("bid")Integer id);

	List<h_title> getTitle(@Param("bid")Integer id);

	List<h_content> getContent(String title);

	void saveContent(@Param("title")String title, @Param("content")String content);

	void saveTitle(@Param("id")Integer id1, @Param("title")String title);

}
