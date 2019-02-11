package com.bishe.web.controller.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.pojo.Comment;
import com.bishe.pojo.NovelType;
import com.bishe.pojo.Search;
import com.bishe.pojo.Shelf;
import com.bishe.service.BookSearchService;


@Controller
@RequestMapping("/search")
public class BookSearchAction {

	@Autowired
	private BookSearchService bookSearchService;
	
	//���ֶβ�ѯ�鼮
	@RequestMapping("/searchbook")
	@ResponseBody
	public List<Search> searchBook(String value1,String value2){
		
		List<Search> list=bookSearchService.searcchBook(value1,value2);
		return list;
		
	} 
	
	//С˵�Ķ�������
	@RequestMapping("/sort")
	@ResponseBody
     public List<NovelType> sort(){
		
		List<NovelType> list=bookSearchService.sort();
		return list;
		
	}
	
	//���Կͻ�����
	@RequestMapping("/returnComment")
	@ResponseBody
	public List<Comment> returnComment(String username)
	{

		List<Comment> list=bookSearchService.findcomment(username);
		return list;
	}
	
	//�������
	@RequestMapping("/returnShelf")
	@ResponseBody
	public List<Shelf> returnShelf(String user_id)
	{
		Integer user_id1=Integer.valueOf(user_id);
		List<Shelf> list=bookSearchService.findshelf(user_id1);
		return list;
	}
	
	
	//�����޸�ҳ��
	@RequestMapping("/saveMessage")
	@ResponseBody
	public String reMessage(String bid,String name,String author,String type,String style,String message){
		
		bookSearchService.saveMessage(bid,name,author,type,style,message);
		
		return "save success";
	}
	
	//����½�
	@RequestMapping("/addTitle")
	@ResponseBody
	public String add(String bid,String title,String content){
		
		bookSearchService.addTitle(bid, title, content);
		return "save success";
	}

	
}
