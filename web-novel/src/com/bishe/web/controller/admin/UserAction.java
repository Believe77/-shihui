package com.bishe.web.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.pojo.User;
import com.bishe.pojo.h_user;
import com.bishe.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	//注入Service
	@Autowired
	private UserService userService;
	
	
	
	//注册
	@RequestMapping("regist")
	@ResponseBody
	public String regist(User user){
		
		User u=userService.findUser(user);//判断注册时用户名是否存在
		if(u!=null)
		{
		    return "name already exit";
		}else{
			
			userService.regist(user);
			return "regist success";
		}
		
	}
	
	//登陆
	@RequestMapping("login")
	@ResponseBody
	public String login(String name,String password){
		
		
		User u=userService.findByName(name);
		System.out.println(u);
		if(u==null)
		{
			return "name no exit";
			
		}else{
			
			if(u.getPassword().equals(password))
			{
				String user_id=u.getId().toString();
				System.out.println(user_id);
				return user_id;
			}else{
				
				return "password error";
			}
		}
		
	}
	
	
	//后台系统登陆
	@RequestMapping("h_login")
	@ResponseBody
	public String h_login(h_user user){
		
		
		h_user u=userService.findHuser(user);
		
		if(u==null)
		{
			return "name no exit";
			
		}else{
			
			if(!u.getPassword().equals(user.getPassword())){
				
				return "password error";
			}else{
				
				if(u.getManger().equals(user.getManger())){
					Integer id=u.getId();
					return id.toString();
				}else{
					
					return "identity error";
				}
			}
		}
		
		
	} 
}
