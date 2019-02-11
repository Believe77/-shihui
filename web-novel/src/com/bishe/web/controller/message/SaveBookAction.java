package com.bishe.web.controller.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.pojo.NovelType;
import com.bishe.pojo.Shelf;
import com.bishe.service.SaveBookService;

@Controller
@RequestMapping("/message")
public class SaveBookAction {

	@Autowired
	private SaveBookService saveBookService;
	
	//保存书籍到书架
	@RequestMapping("/save")
	@ResponseBody
	public String SaveBook(String bid,String id){
		
		Integer bid1=Integer.valueOf(bid);
		
		NovelType n=saveBookService.findBook(bid1);
		
		Shelf s=new Shelf();
		s.setName(n.getName());
		s.setPath(n.getPath());
		s.setAuthor(n.getAuthor());
		s.setBid(bid1);
		
		
		s.setMessage(n.getMessage());
		s.setType(n.getType());
		s.setStyle(n.getStyle());
		s.setCountNumber(n.getCountNumber());
		Integer id1=Integer.valueOf(id);
		s.setUser_id(id1);
		
		saveBookService.saveBook(s);
		
		return "save success";
		
	}
	
	//点击阅读量的累加
	@RequestMapping("/count")
	@ResponseBody
	public String countBook(String bid){
		
		Integer bid2=Integer.valueOf(bid);
		
		Integer count=saveBookService.findCount(bid2);
		
		Integer cishu=count+1;
		
		saveBookService.saveCount(cishu,bid2);
		
		return "ok";
		
	}
	
	
	//询问前端用户是否可以评论
	@RequestMapping("/askComment")
	@ResponseBody
	public String ask(String user_id){
		System.out.println(user_id);
		Integer id=Integer.valueOf(user_id);
		String forbidden=saveBookService.ask(id);
		return forbidden;
	}
	
	
	
}
