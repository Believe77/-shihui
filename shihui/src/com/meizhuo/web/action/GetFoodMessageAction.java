package com.meizhuo.web.action;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.meizhuo.pojo.Foods;
import com.meizhuo.service.GetFoodMessageService;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope(value="prototype")
@ParentPackage("struts-default")
public class GetFoodMessageAction extends ActionSupport{

	private String window_id;

	public String getWindow_id() {
		return window_id;
	}

	public void setWindow_id(String window_id) {
		this.window_id = window_id;
	}
	
	
	@Resource
	private GetFoodMessageService getFoodMessageService;

	@Action(value="getfoodmessage")
	public String getFoodMessage() throws Exception {
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		

		response.setHeader("Access-Control-Allow-Origin", "*");
		

		String pid=window_id; 
		
		String pids = pid;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null)
		{
			for(Cookie cookie : cookies)
			{
				if("pids".equals(cookie.getName()))
				{
					pids = cookie.getValue();
					
					String[] split = pids.split("-");
					List<String> asList = Arrays.asList(split);
					LinkedList<String> list = new LinkedList<String>(asList);
					
					if(list.contains(pid)){
						
						list.remove(pid);
						list.addFirst(pid);
					}else{
						
						list.addFirst(pid);
					}
					
					StringBuffer sb = new StringBuffer();
					for(int i=0;i<list.size()&&i<7;i++)
					{
						sb.append(list.get(i));
						sb.append("-");
					}
					
					   pids = sb.substring(0, sb.length()-1);
				}
			}
		}
		

		Cookie cookie_pids = new Cookie("pids",pids);
		response.addCookie(cookie_pids);
		
		
		
		
		List<Foods> list=getFoodMessageService.getFoodMessage(window_id);
		response = ServletActionContext.getResponse();

		response.setHeader("Access-Control-Allow-Origin", "*");
		
		Gson gson=new Gson();
		String json=gson.toJson(list);
	
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		
		return null;
	}
	
	
	
	
}
