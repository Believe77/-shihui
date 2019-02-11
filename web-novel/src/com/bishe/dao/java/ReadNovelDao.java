package com.bishe.dao.java;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bishe.pojo.Comment;
import com.bishe.pojo.Hot;
import com.bishe.pojo.Section;

public interface ReadNovelDao {

	List<Section> read(@Param("bid")Integer bid1);

	void comment(@Param("username")String username, @Param("bname")String bname,
			@Param("title")String title, 
			@Param("comment")String comment,@Param("date")String date, @Param("path")String path);

	List<Hot> get(@Param("bid")Integer id);


	void deleteComment(@Param("username")String username, @Param("date")String date);

	void delete(@Param("user_id")Integer id,@Param("name")String name);

	List<Comment> findComment(String title);

	String fianImage(@Param("id")Integer user_id1);

	String findName(@Param("id")Integer user_id1);

}
