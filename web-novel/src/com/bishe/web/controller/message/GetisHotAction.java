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
	
	//��ȡ�Ƽ��������鼮
	@RequestMapping("/ishot")
	@ResponseBody
	public List<Hot> getisHot(String ishot)
	{
		
		List<Hot> list=getisHotService.findIsHot(ishot);
		
		return list;
		
	}
	
	
	//��̨��ȡ�鼮����
	@RequestMapping("/h_type")
	@ResponseBody
	public List<h_type> h_type(){
		
		List<h_type> list=getisHotService.findtype();
		
		return list;
	}
	
	//ɾ���鼮����
	@RequestMapping("/delete_type")
	@ResponseBody
	public String delete(String t_id){
		
		Integer id=Integer.valueOf(t_id);
		getisHotService.delete(id);
		
		return "delete success";
	}
	
	//����鼮����
	@RequestMapping("/add_type")
	@ResponseBody
	public String add(String type){
		
		
		getisHotService.add(type);
		
		return "save success";
	}
	
	//��̨���Ҷ�Ӧ�����͵��鼮
	@RequestMapping("/type_book")
	@ResponseBody
	public List<h_book> type_book(String type){
		
		List<h_book> list=getisHotService.findTypebook(type);
		
		return list;
		
	}
	
	
		
}
