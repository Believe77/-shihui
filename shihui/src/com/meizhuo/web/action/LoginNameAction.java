package com.meizhuo.web.action;


/**
 * @ProjectName: shiwei
 * @Package: com.meizhuo.web.action
 * @Description:回显登陆名和个人信息
 * @Author:weitao
 * @CreateDate: 2018/9
 * @UpdateDate: 2018/9
 * @Version: 1.0
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.meizhuo.pojo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope(value="prototype")
@ParentPackage("struts-default")
public class LoginNameAction extends ActionSupport{

	@Action(value="returnMessage")
	public String returnMessage() throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();

		response.setHeader("Access-Control-Allow-Origin", "*");
		
        List<User> list=new ArrayList<User>();
		
       
        /*User u=new User();
        u.setUser_code("ΰ��");
        
        /*ActionContext.getContext().getSession().put("user", u);*/
        
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		
		list.add(user);
		Gson gson=new Gson();
		String json=gson.toJson(list);
	
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);	
		
		return null;
	}

	
	
}
