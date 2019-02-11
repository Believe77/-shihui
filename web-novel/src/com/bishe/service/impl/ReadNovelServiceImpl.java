package com.bishe.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.dao.java.ReadNovelDao;
import com.bishe.pojo.Comment;
import com.bishe.pojo.Hot;
import com.bishe.pojo.Section;
import com.bishe.service.ReadNovelService;

@Service
public class ReadNovelServiceImpl implements ReadNovelService {

	@Autowired
	private ReadNovelDao readNovleDao;
	
	
	public List<Section> read(Integer bid1) {
		// TODO Auto-generated method stub
		return readNovleDao.read(bid1);
	}


	public void comment(String username, String bname, String title, String comment,String date,String path) {
		
		readNovleDao.comment(username,bname,title,comment,date,path);
		
	}


	public List<Hot> get(Integer id) {
		// TODO Auto-generated method stub
		return readNovleDao.get(id);
	}



	public void deleteBook(@Param("user_id")Integer id,@Param("name")String name) {
		// TODO Auto-generated method stub
		readNovleDao.delete(id,name);
	}


	public List<Comment> findComment(String title) {
		// TODO Auto-generated method stub
		return readNovleDao.findComment(title);
	}


	public String findImage(Integer user_id1) {
		
		return readNovleDao.fianImage(user_id1);
	}



	public String findName(Integer user_id1) {
		// TODO Auto-generated method stub
		return readNovleDao.findName(user_id1);
	}


	public void deleteComment(String username, String date) {
		// TODO Auto-generated method stub
		readNovleDao.deleteComment(username,date);
	}

}
