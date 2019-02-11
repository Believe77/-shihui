package com.bishe.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bishe.pojo.NovelType;
import com.bishe.pojo.PersonalImage;
import com.bishe.pojo.User;
import com.bishe.service.PersonalMessageService;


@Controller
@RequestMapping(value="/user")
@ResponseBody
public class PersonMessageAction {

	@Autowired
	private PersonalMessageService personalMessageService;
	
	
	//���������Ϣ
	@RequestMapping(value="saveMessage")
	public String saveMessage(User user)    
	{
		personalMessageService.saveMessage(user);
		return "save success";
		
	}
	
	
	
	@RequestMapping("/upload")
	@ResponseBody
    public String upload(String path,String name,String author,String type,String style,String message) {
		
      
           personalMessageService.upload2(path,name,author,type,style,message); 
           
           return "save success";
           
           
    }
	
	//���Ը�����Ϣ
	@RequestMapping("/returnPerMessage")
	public User returnPerMessage(String user_id)
	{
		Integer id=Integer.valueOf(user_id);
		User user=personalMessageService.findPerMessage(id);
		return user;
		
	}
	
	//���ظ���ͷ��·��
	@RequestMapping("/perImage")
	@ResponseBody
	public List<PersonalImage> getImage(){
		
		List<PersonalImage> list=personalMessageService.getImage();
		return list;
	}

	//�����޸���Ϣ
	@RequestMapping("/returnMessage")
	@ResponseBody
	public List<NovelType> reMessage(String name){
		
		List<NovelType> list=personalMessageService.findMessage(name);
		return list;
	}

}
