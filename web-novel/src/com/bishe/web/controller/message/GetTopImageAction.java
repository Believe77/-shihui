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
	
	
	//��ȡ�ֲ�ͼ��ַ
	@RequestMapping("topImage")
	@ResponseBody
	public List<TopImage> getImage()
	{
		
		List<TopImage> list=getImageService.find();
		return list;
		
	}
	
	
	//��ȡ����Ա�˺���Ϣ
	@RequestMapping("userManger")
	@ResponseBody
	public List<User> userManger(){
		
		List<User> list=getImageService.getUserMessage();
		
		return list;
		
	}
	
	
	//��ȡ��ͨ�û��˺���Ϣ
	@RequestMapping("userCommon")
	@ResponseBody
	public List<User> userCommon(){
		
		List<User> list=getImageService.getUserCommon();
		return list;
	}
	
	
	//������������Ա
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
	
	//����Ա���Թ���
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

	//����������Ҫ��ֹ�������򷵻�
	@RequestMapping("returnForbidden")
	@ResponseBody
	public List<h_user> returnForbidden(){
		
		List<h_user> list=getImageService.returnForbidden();
		
		return list;
	}
	
	//������˺�����״̬
	@RequestMapping("returnCon")
	@ResponseBody
	public List<h_comment> returncom(String title){
		
		List<h_comment> list=getImageService.getComment(title);
		return list;
	}
	
	
	//����״̬�ı�
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
