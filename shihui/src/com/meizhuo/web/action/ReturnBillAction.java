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
import com.meizhuo.pojo.User;
import com.meizhuo.pojo.Zhangdang;
import com.meizhuo.service.ReturnBillService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope(value="prototype")
@ParentPackage("lanjieqi")
public class ReturnBillAction extends ActionSupport{

	@Resource
	private ReturnBillService returnBillService;

	@Action(value="returnBill")
	public String returnBill() throws Exception {
		
		HttpServletResponse response=ServletActionContext.getResponse();
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		User u2 = (User) session.get("user");
		String user=u2.getUser_code();
		
		/*String user="weitao";*/
		
		List<Zhangdang> list=returnBillService.find(user);
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		Gson gson=new Gson();
		String json=gson.toJson(list);
	
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		
		return null;
	}
	
	
	
	
	
}
