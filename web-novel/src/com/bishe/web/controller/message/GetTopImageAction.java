package com.bishe.web.controller.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.pojo.TopImage;
import com.bishe.pojo.User;
import com.bishe.pojo.h_comment;
import com.bishe.pojo.h_user;
import com.bishe.service.GetImageService;

@Controller
@RequestMapping("/message")
public class GetTopImageAction {

	@Autowired
	private GetImageService getImageService;
	
	
	//获取轮播图地址
	@RequestMapping("topImage")
	@ResponseBody
	public List<TopImage> getImage()
	{
		
		List<TopImage> list=getImageService.find();
		return list;
		
	}
	
	
	//获取管理员账号信息
	@RequestMapping("userManger")
	@ResponseBody
	public List<User> userManger(){
		
		List<User> list=getImageService.getUserMessage();
		
		return list;
		
	}
	
	
	//获取普通用户账号信息
	@RequestMapping("userCommon")
	@ResponseBody
	public List<User> userCommon(){
		
		List<User> list=getImageService.getUserCommon();
		return list;
	}
	
	
	//升级或撤销管理员
	@RequestMapping("handle")
	@ResponseBody
	public String handle(String name,String manger){
		
		String chuli;
		
		if(manger.equals("1")){
			System.out.println(manger);
			 chuli="0";
		}else{
			 chuli="1";
		}
			
		getImageService.handle(name,chuli);
		return "handle success";
	} 
	
	//管理员禁言功能
	@RequestMapping("forbidden")
	@ResponseBody
	public String forbidden(String name,String ban){
		
		String chuli;
		if(ban.equals("0"))
		{
			chuli="1";
		}else{
			
			chuli="0";
		}
		
		getImageService.forbidden(name,chuli);
		
		return "forbidden success";
				
	}

	//返回名单，要禁止次序排序返回
	@RequestMapping("returnForbidden")
	@ResponseBody
	public List<h_user> returnForbidden(){
		
		List<h_user> list=getImageService.returnForbidden();
		
		return list;
	}
	
	//返回审核和评论状态
	@RequestMapping("returnCon")
	@ResponseBody
	public List<h_comment> returncom(String title){
		
		List<h_comment> list=getImageService.getComment(title);
		return list;
	}
	
	
	//评论状态改变
	@RequestMapping("mix")
	@ResponseBody
	public String mix(String name,String zhuangtai,String date){
		
		String chuli;
		if(zhuangtai.equals("0"))
		{
			Integer forbiddenNumber=getImageService.findNumber(name);
			System.out.println(forbiddenNumber);
			forbiddenNumber++;
			getImageService.saveNumber(forbiddenNumber,name);
			chuli="1";
		}else{
			chuli="0";
		}
		System.out.println(chuli);
		getImageService.mix(chuli,name,date);
		return "success";
	}
	
}
