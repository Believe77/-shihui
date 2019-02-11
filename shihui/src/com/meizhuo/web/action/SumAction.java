package com.meizhuo.web.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.meizhuo.pojo.Sum;
import com.meizhuo.pojo.User;
import com.meizhuo.service.SumService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope(value="prototype")
@ParentPackage("lanjieqi")
public class SumAction extends ActionSupport{

	@Resource
	private SumService sumService;
	
	
	private String sum;

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	@Action(value="sum")
	public String sum() throws Exception {
		
		User u=new User();
        u.setUser_code("weitao");
        u.setUser_password("123456");
        ActionContext.getContext().getSession().put("user", u);
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		User u2 = (User) session.get("user");
		
		String user_code=u2.getUser_code();
		
		Sum s=new Sum();
		
		s.setNum(sum);
		s.setUser_code(user_code);
		
		sumService.save(s);
		
		return null;
		
	}
	
	
}
