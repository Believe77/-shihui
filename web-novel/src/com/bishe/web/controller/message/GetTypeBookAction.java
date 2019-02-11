package com.bishe.web.controller.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.pojo.NovelType;
import com.bishe.pojo.h_content;
import com.bishe.pojo.h_title;
import com.bishe.service.GetTypeBookService;

@Controller
@RequestMapping("/message")
public class GetTypeBookAction {

	@Autowired
	private GetTypeBookService getTypeBookService;
	
	//获取对应类型的书籍
	@RequestMapping("/type")
	@ResponseBody
	public List<NovelType> findBookType(String type){
		
		List<NovelType> list=getTypeBookService.findBookType(type);		
		
		return list;
	}
	
	//后台删除某一本书
	@RequestMapping("/delete_book")
	@ResponseBody
	public String deleteBook(String bid){
		
		Integer id=Integer.valueOf(bid);
		getTypeBookService.deletebook(id);
		
		
		return "delete success";
	}
	
	//后台获取书本的章节
	@RequestMapping("/get_title")
	@ResponseBody
	public List<h_title> getTitle(String bid){
		
		Integer id=Integer.valueOf(bid);
		List<h_title> list=getTypeBookService.getTitle(id);
		return list;
	}
	
	//后台获取章节的内容
	@RequestMapping("/get_content")
	@ResponseBody
	public List<h_content> getContent(String title){
		
		List<h_content> list=getTypeBookService.getContent(title);
		return list;
	}
	
	//章节内容修改后保存
	@RequestMapping("/save_content")
	@ResponseBody
	public String saveContent(String title,String content){
		
		getTypeBookService.saveContent(title,content);
		return "save success";
	}
	
	//后台修改章节名
	@RequestMapping("/save_title")
	@ResponseBody
	public String savetitle(String id,String title){
		
		Integer id1=Integer.valueOf(id);
		getTypeBookService.saveTitle(id1,title);
		
		return "save success";
	}
	
}
