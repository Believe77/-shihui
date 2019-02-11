package com.bishe.service;

import java.util.List;

import com.bishe.pojo.Comment;
import com.bishe.pojo.Hot;
import com.bishe.pojo.Section;


public interface ReadNovelService {

	List<Section> read(Integer bid1);

	void comment(String username, String bname, String title, String comment, String date, String path);

	List<Hot> get(Integer id);

	

	void deleteComment(String username, String date);

	void deleteBook(Integer id, String name);

	List<Comment> findComment(String title);

	String findImage(Integer user_id1);

	String findName(Integer user_id1);

	
	
}
