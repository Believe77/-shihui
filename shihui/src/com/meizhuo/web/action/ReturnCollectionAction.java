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
import com.meizhuo.pojo.Collection;
import com.meizhuo.service.ReturnCollectionService;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope(value="prototype")
@ParentPackage("struts-default")
public class ReturnCollectionAction extends ActionSupport{

	@Resource
	private ReturnCollectionService returnCollectionService;

	@Action(value="returncol")
	public String retuencol() throws Exception {
		
		List<Collection> list=returnCollectionService.search();
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setHeader("Access-Control-Allow-Origin", "*");
		
		Gson gson=new Gson();
		String json=gson.toJson(list);
	
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		
		return null;
		
	}
	
	
	
}
