package com.bishe.web.controller.search;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.pojo.Comment;
import com.bishe.pojo.Hot;
import com.bishe.pojo.Section;
import com.bishe.service.ReadNovelService;

@Controller
@RequestMapping("/search")
public class ReadNovelAction {

	@Autowired
	private ReadNovelService readNovelService;
	
	//获取小说目录及对应内容
	@RequestMapping("/readnovel")
	@ResponseBody
	public List<Section> read(String bid){
		
		Integer bid1=Integer.valueOf(bid);
		List<Section> list= readNovelService.read(bid1);
		
		return list;
		
	}
	
	//每一章节评论
	@RequestMapping("/comment")
	@ResponseBody
	public String comment(String user_id,String bname,String title,String comment){
		
		Integer user_id1=Integer.valueOf(user_id);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date=df.format(new Date());
		
		String path=readNovelService.findImage(user_id1);
		String username=readNovelService.findName(user_id1);
		
		readNovelService.comment(username,bname,title,comment,date,path);
		
		return "save success";
		
	}
	
	//书籍下载
	@RequestMapping("/download")
	@ResponseBody
	public void  download(String filename,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		System.out.println(filename); 
        String path="C:\\upload\\"+filename;
        System.out.println(path);
        
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
     
        filename = URLEncoder.encode(filename,"UTF-8");  
        
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
         
        response.setContentType("multipart/form-data");   
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
        int len = 0;  
        while((len = bis.read()) != -1){  
            out.write(len);  
            out.flush();  
        }  
        out.close();  
    } 
	
	//通过bid获取书籍信息
	@RequestMapping("/get")
	@ResponseBody
	public List<Hot> get(String bid){
		
		Integer id=Integer.valueOf(bid);
		List<Hot> list=readNovelService.get(id);
		return list;
	}
	
	//返回评论时的评论
	@RequestMapping("/returnTitleComment")
	@ResponseBody
	public List<Comment> returnPer(String title){
		
		List<Comment> list=readNovelService.findComment(title);
		return list;
	}
	
	
	//删除评论
	@RequestMapping("/deletePerComment")
	@ResponseBody
	public String deleteComment(String username,String date){
		
		readNovelService.deleteComment(username,date);
		
		return "delete success";
	}
	
	
	//删除书架上的书
	@RequestMapping("/deleteBook")
	@ResponseBody
	public String delete(String user_id,String name){
		
		Integer id=Integer.valueOf(user_id);
		readNovelService.deleteBook(id,name);
		return "delete success";
	}
}
