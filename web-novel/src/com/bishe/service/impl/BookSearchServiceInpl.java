package com.bishe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.dao.java.BookSearchDao;
import com.bishe.pojo.Comment;
import com.bishe.pojo.NovelType;
import com.bishe.pojo.Search;
import com.bishe.pojo.Shelf;
import com.bishe.service.BookSearchService;

@Service
public class BookSearchServiceInpl implements BookSearchService {

	
	@Autowired
	private BookSearchDao bookSearchServicDao;
	
	public List<Search> searcchBook(String value1,String value2) {
		// TODO Auto-generated method stub
		return bookSearchServicDao.searchBook(value1,value2);
	}

	public List<NovelType> sort() {
		// TODO Auto-generated method stub
		return bookSearchServicDao.sort();
	}

	public List<Comment> findcomment(String username) {
		// TODO Auto-generated method stub
		return bookSearchServicDao.findcomment(username);
	}

	public List<Shelf> findshelf(Integer user_id1) {
		// TODO Auto-generated method stub
		return bookSearchServicDao.findshelf(user_id1);
	}

	public void saveMessage(String bid, String name, String author, String type, String style, String message) {
		// TODO Auto-generated method stub
		bookSearchServicDao.saveMessage(bid,name,author,type,style,message);
	}

	public void addTitle(String bid, String title, String content) {
		// TODO Auto-generated method stub
		bookSearchServicDao.addTitle(bid,title,content);
	}

}
