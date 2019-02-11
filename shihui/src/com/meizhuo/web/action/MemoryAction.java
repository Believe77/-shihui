package com.meizhuo.web.action;

import java.util.ArrayList;
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
import com.meizhuo.pojo.window;
import com.meizhuo.service.MemoryService;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope(value="prototype")
@ParentPackage("struts-default")
public class MemoryAction extends ActionSupport{

	@Resource
	private MemoryService memoryService;

	@Action(value="memory")
	public String memory() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		List<window> historyProductList = new ArrayList<window>();

         
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if("pids".equals(cookie.getName())){
					String pids = cookie.getValue();
					String[] split = pids.split("-");
					for(String pid : split){
						System.out.println(pid);
						window win = memoryService.findWindowNameById(pid);
						historyProductList.add(win);
					}
				}
			}
		}
		
		Gson gson=new Gson();
		String json=gson.toJson(historyProductList);
	
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		
		return null;
		
	}
	
	
}
