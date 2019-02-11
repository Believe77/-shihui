package com.meizhuo.web.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.meizhuo.pojo.window;
import com.meizhuo.service.GetWindowNameService;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope(value="prototype")
@ParentPackage("struts-default")
public class GetWindowNameAction extends ActionSupport{

	private String carteen_id;
	
	public String getCarteen_id() {
		return carteen_id;
	}


	public void setCarteen_id(String carteen_id) {
		this.carteen_id = carteen_id;
	}

    @Resource
	private GetWindowNameService getWindowNameService;

	@Action("getname")
	public String getname() throws Exception {
		
		 List<window> list=getWindowNameService.checkWindowName(carteen_id);
		 
		 HttpServletResponse response = ServletActionContext.getResponse();

		 response.setHeader("Access-Control-Allow-Origin", "*");
		 
		Gson gson=new Gson();
		String json=gson.toJson(list);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		
		return null;
		
	}
	
	
	
}
