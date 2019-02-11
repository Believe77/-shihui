package com.meizhuo.web.action;

import java.io.File;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.meizhuo.pojo.User;
import com.meizhuo.service.UserPictureService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope(value="prototype")
@ParentPackage("struts-default")
public class UserPictureAction extends ActionSupport {

	private File user_path;
	
	private String user_pathFileName;
	
	@Resource
	private UserPictureService userPictureService;

	public File getUser_path() {
		return user_path;
	}

	public void setUser_path(File user_path) {
		this.user_path = user_path;
	}

	public String getUser_pathFileName() {
		return user_pathFileName;
	}

	public void setUser_pathFileName(String user_pathFileName) {
		this.user_pathFileName = user_pathFileName;
	}
	
	@Action(value="sendheadpicture")
	public String sendheadpicture() throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		
	   String path="C:/upload/"+user_pathFileName;
	 
	   user_path.renameTo(new File(path));
       
	   Map<String, Object> session = ActionContext.getContext().getSession();
	   User u2 = (User) session.get("user");
	   
	   /*User u2=new User();
	   u2.setUser_code("weitao");*/
	   
	   userPictureService.save(path,u2);
	   
	   
	   Gson gson=new Gson();
	   String json=gson.toJson(path);
	   ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
	   ServletActionContext.getResponse().getWriter().write(json);
	   
       return null;
	 
	}
	
}
