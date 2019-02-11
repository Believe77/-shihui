package com.meizhuo.web.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.meizhuo.pojo.User;
import com.meizhuo.service.PersonalMessageService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Component
@Scope(value="prototype")
@ParentPackage("lanjieqi")
public class PersonalMessageAction extends ActionSupport implements ModelDriven<User>{

	private User user=new User();
		
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Resource
	private PersonalMessageService personalMessageService;
	

	

	@Action(value="permessage",results={@Result(name="mymain",location="/index.jsp")})
	public String perMessage() throws Exception {
		
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setHeader("Access-Control-Allow-Origin", "*");
		
		/*User u=new User();
        u.setUser_code("weitao");
        u.setUser_password("123456");
        ActionContext.getContext().getSession().put("user", u);*/
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		User u2 = (User) session.get("user");
		
	    /*User user=new User();
	    user.setUser_address("dsf");
	    user.setUser_name("sdf");
	    user.setUser_phone("110");
	    user.setUser_sex("1");*/
		
		user.setUser_code(u2.getUser_code());
		user.setUser_password(u2.getUser_password());
		
		ActionContext.getContext().getSession().put("user", user);
		
		personalMessageService.save(user);
		
		
		return "mymain";
	}

	@Override
	public User getModel() {
		return user;
	}

}
