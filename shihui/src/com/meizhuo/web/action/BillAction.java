package com.meizhuo.web.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.meizhuo.pojo.Foods;
import com.meizhuo.pojo.User;
import com.meizhuo.pojo.Zhangdang;
import com.meizhuo.service.BillService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope(value="prototype")
@ParentPackage("struts-default")
public class BillAction extends ActionSupport{

	@Resource
	private BillService billService;
	
	private String window_id;
	
	private String bill;//µã²ËµÄid×Ö·û´®
	

	public String getWindow_id() {
		return window_id;
	}

	public void setWindow_id(String window_id) {
		this.window_id = window_id;
	}

	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	@Action(value="bill")
	public String bill() throws Exception {
			
		
		//²âÊÔ
	   /*User u=new User();
        u.setUser_code("weitao");
        u.setUser_password("123456");
        ActionContext.getContext().getSession().put("user", u);*/
			
		Map<String, Object> session = ActionContext.getContext().getSession();
		User u2 = (User) session.get("user");
		
		for(int i=0;i<bill.length();i++)
		{
			Zhangdang zd=new Zhangdang();
			zd.setZhang_user(u2.getUser_code());
			zd.setWindow_id(window_id);
			char ch=bill.charAt(i);
			Foods f=billService.find(Integer.valueOf(String.valueOf(ch)));
			
			Integer food_id=f.getFood_id();
			Integer food_count=f.getFood_count();
			food_count++;
			billService.update(food_count,food_id);
			
			zd.setZhang_price(f.getFood_price());
			zd.setZhang_food(f.getFood_name());
			zd.setZhang_count("1");
			zd.setZhang_state("0");
			billService.save(zd);
		}
		
		
		return null;
	}
	
	
}
