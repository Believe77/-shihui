package com.meizhuo.web.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.meizhuo.pojo.Collection;
import com.meizhuo.pojo.window;
import com.meizhuo.service.CollectionService;
import com.meizhuo.service.MemoryService;
import com.opensymphony.xwork2.ActionSupport;


@Component
@Scope(value="prototype")
@ParentPackage("struts-default")
public class CollectionAction extends ActionSupport {

	
	private String window_id;

	public String getWindow_id() {
		return window_id;
	}

	public void setWindow_id(String window_id) {
		this.window_id = window_id;
	}
	
	@Resource
	private CollectionService collectionService;
	
	@Resource
	private MemoryService memoryService;
	
	

	@Action(value="findfoodmessage")
	public String findfoodmessage() throws Exception {
		
		window win=memoryService.findWindowNameById(window_id);
		Collection col=new Collection();
		
		col.setCol_name(win.getWindow_name());
		col.setCol_path(win.getWindow_path());
		col.setCol_adress(win.getWindow_address());
		
		collectionService.save(col);
		
		return null;
		
	}
	
	 ;
	
}
