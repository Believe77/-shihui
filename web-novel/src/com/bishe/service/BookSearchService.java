package com.bishe.service;

import java.util.List;

import com.bishe.pojo.Comment;
import com.bishe.pojo.NovelType;
import com.bishe.pojo.Search;
import com.bishe.pojo.Shelf;

public interface BookSearchService {


	List<Search> searcchBook(String value1, String value2);

	List<NovelType> sort();

	List<Comment> findcomment(String username);

	List<Shelf> findshelf(Integer user_id1);

	void saveMessage(String bid, String name, String author, String type, String style, String message);

	void addTitle(String bid, String title, String content);

}
