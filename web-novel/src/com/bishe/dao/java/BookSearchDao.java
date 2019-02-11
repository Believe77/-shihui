package com.bishe.dao.java;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bishe.pojo.Comment;
import com.bishe.pojo.NovelType;
import com.bishe.pojo.Search;
import com.bishe.pojo.Shelf;

public interface BookSearchDao {

	List<Search> searchBook(@Param("name")String value, @Param("value")String value2);

	List<NovelType> sort();

	List<Comment> findcomment(@Param("username")String username);

	List<Shelf> findshelf(@Param("user_id")Integer user_id1);

	void saveMessage(@Param("bid")String bid, @Param("name")String name, @Param("author")String author, @Param("type")String type, @Param("style")String style, @Param("message")String message);

	void addTitle(@Param("bid")String bid, @Param("title")String title, @Param("content")String content);

}
