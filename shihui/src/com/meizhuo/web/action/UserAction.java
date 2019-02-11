package com.meizhuo.web.action;



/**
 * @ProjectName: shiwei
 * @Package: com.meizhuo.web.action
 * @Description:µÇÂ½×¢²á
 * @Author:weitao
 * @CreateDate: 2018/9
 * @UpdateDate: 2018/10
 * @Version: 2.0
 **/


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.meizhuo.pojo.User;
import com.meizhuo.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Component
@Scope(value="prototype")
@ParentPackage("struts-default")
public class UserAction extends ActionSupport {
	
	private String user_code;
	private String user_password;
	
	

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	@Resource
	private UserService userService ;
	

	
	@Action(value="login")
	public String login() throws Exception {
			
		   User user=new User();
		   user.setUser_code(user_code);
		   user.setUser_password(user_password); 
		   
		    HttpServletResponse response = ServletActionContext.getResponse();
			ActionContext.getContext().getSession().put("user", user);
			User u=userService.getUserByCodePassword(user);
			response.setHeader("Access-Control-Allow-Origin", "*");
			
			if(u!=null)
			{
				if(u.getUser_password().equals(user.getUser_password()))
				{
					
					Gson gson=new Gson();
					String json=gson.toJson("success");
					ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
					ServletActionContext.getResponse().getWriter().write(json);
				}else{
					Gson gson=new Gson();
					String json=gson.toJson("error");
					ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
					ServletActionContext.getResponse().getWriter().write(json);
				}
			}
			
			return null;
			
	}
	
	@Action(value="regist")
	public String regist()throws Exception{
		  System.out.println(user_code);
		
		   User user=new User();
		   user.setUser_code(user_code);
		   user.setUser_password(user_password);
	       HttpServletResponse response = ServletActionContext.getResponse();
	       User u=userService.getUserByCodePassword(user);
		   response.setHeader("Access-Control-Allow-Origin", "*");
	      
		   if(u!=null)
		   {
			   Gson gson=new Gson();
			   String json=gson.toJson("success");
			
			   ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
			   ServletActionContext.getResponse().getWriter().write(json);

		   }else{
			     
			      userService.saveUser(user);
			    
		   }	   
		   return null;
	}

	

	
}
