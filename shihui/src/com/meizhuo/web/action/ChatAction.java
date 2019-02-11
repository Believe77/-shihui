package com.meizhuo.web.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.meizhuo.pojo.Chat;
import com.meizhuo.pojo.User;
import com.meizhuo.service.ChatService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope(value="prototype")
@ParentPackage("lanjieqi")
public class ChatAction extends ActionSupport {

	private String message;
	
	@Resource
	private ChatService chatService;
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Action(value="chat")
	public String chat() throws Exception {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		User u=new User();
        u.setUser_code("weitao");
        u.setUser_password("123456");
        ActionContext.getContext().getSession().put("user", u);
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		User u2 = (User) session.get("user");
		
		String user_code=u2.getUser_code();
		Chat c=new Chat();
		c.setMessage(message);
		c.setUser_code(user_code);
		
		chatService.save(c);
		List<Chat> list=chatService.find();
		
		Gson gson=new Gson();
		String json=gson.toJson(list);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	
	
	
}
