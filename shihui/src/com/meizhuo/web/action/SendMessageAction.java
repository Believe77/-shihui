package com.meizhuo.web.action;

import java.util.Random;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.meizhuo.pojo.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope(value="prototype")
@ParentPackage("struts-default")
public class SendMessageAction extends ActionSupport{

	private String user_code;
	private String user_phone;

	
	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	@Action(value="sendMessage")
	public String sendMessage() throws Exception {
	
        String name=user_code;
		
		String str="0123456789";
		StringBuilder sb=new StringBuilder(4);
		for(int i=0;i<4;i++)
		{
		char ch=str.charAt(new Random().nextInt(str.length()));
		sb.append(ch);
		}
		String message=sb.toString();//验证码
		
		Message m=new Message();
		m.setMessage(message);
		
		ActionContext.getContext().getSession().put("message",m);
		
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.api.smschinese.cn/"); 
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
		NameValuePair[] data ={ new NameValuePair("Uid","believe7"),new NameValuePair("Key", "d41d8cd98f00b204e980"),
				new NameValuePair("smsMob",user_phone),new NameValuePair("smsText",""+name+"你好，你的验证码为"+message+" 【食未团队】")};
		post.setRequestBody(data);

		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		for(Header h : headers)
		{
		System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("gbk")); 
		System.out.println(result);


		post.releaseConnection();

		
		return null;
	}
	
	
	
	
}
