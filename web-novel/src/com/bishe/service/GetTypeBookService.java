package com.bishe.service;

import java.util.List;

import com.bishe.pojo.NovelType;
import com.bishe.pojo.h_content;
import com.bishe.pojo.h_title;

public interface GetTypeBookService {

	List<NovelType> findBookType(String type);

	void deletebook(Integer id);

	List<h_title> getTitle(Integer id);

	List<h_content> getContent(String title);

	void saveContent(String title, String content);

	void saveTitle(Integer id1, String title);

}
