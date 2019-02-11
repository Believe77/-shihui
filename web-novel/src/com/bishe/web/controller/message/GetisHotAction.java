package com.bishe.web.controller.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.pojo.Hot;
import com.bishe.pojo.h_book;
import com.bishe.pojo.h_type;
import com.bishe.service.GetisHotService;

@Controller
@RequestMapping("/message")
public class GetisHotAction {

	@Autowired
	private GetisHotService getisHotService;
	
	//获取推荐或热门书籍
	@RequestMapping("/ishot")
	@ResponseBody
	public List<Hot> getisHot(String ishot)
	{
		
		List<Hot> list=getisHotService.findIsHot(ishot);
		
		return list;
		
	}
	
	
	//后台获取书籍类型
	@RequestMapping("/h_type")
	@ResponseBody
	public List<h_type> h_type(){
		
		List<h_type> list=getisHotService.findtype();
		
		return list;
	}
	
	//删除书籍类型
	@RequestMapping("/delete_type")
	@ResponseBody
	public String delete(String t_id){
		
		Integer id=Integer.valueOf(t_id);
		getisHotService.delete(id);
		
		return "delete success";
	}
	
	//添加书籍类型
	@RequestMapping("/add_type")
	@ResponseBody
	public String add(String type){
		
		
		getisHotService.add(type);
		
		return "save success";
	}
	
	//后台查找对应书类型的书籍
	@RequestMapping("/type_book")
	@ResponseBody
	public List<h_book> type_book(String type){
		
		List<h_book> list=getisHotService.findTypebook(type);
		
		return list;
		
	}
	
	
		
}
