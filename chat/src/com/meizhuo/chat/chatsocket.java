package com.meizhuo.chat;



import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.jasper.el.ELContextWrapper;

import com.google.gson.Gson;
import com.sun.xml.internal.bind.v2.model.core.ID;



@ServerEndpoint("/chatSocket")
public class chatsocket {

	private String username;
	private static List<Session> sessions=new ArrayList<Session>();
	private static List<String> names=new ArrayList<String>();
	
	//将用户和session对应起来，单聊是时可以用用户名找到该用户session管道以此来发送信息
	private static Map<String, Session> map=new HashMap<String,Session>();
	
	
	@OnOpen
	public void open(Session session){
		
		/*
		 * 虽然前面我们将username放在session中，
		 * 但是此时的session是websocket的session，
		 * 不是servlet中的session
		 */
		
		String name=session.getQueryString();//获取路径问号后面的参数内容
		
		username=name.split("=")[1];
		
		this.names.add(username);
		this.sessions.add(session);
		this.map.put(this.username,session);//对应起来
		String msg="欢迎"+username+"来到聊天室<br/>";
		
		chat c=new chat();
		c.setWelcome(msg);
		c.setUsername(this.names);
		
		//System.out.println(c.getUsername());
		this.broadcast(this.sessions,c.toJson()); 
	}

	public void broadcast(List<Session> session2, String msg) {
		// TODO Auto-generated method stub
        for(Iterator iterator=session2.iterator();iterator.hasNext();){
        
        	Session session=(Session) iterator.next();
        	
        	try {
        		//System.out.println(msg);
				session.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
	@OnClose
	public void close(Session session){
		
		this.sessions.remove(session);
		this.names.remove(this.username);
		
		String msg=("欢送"+username+"离开到聊天室<br/>");
	    chat c1=new chat();
	    c1.setWelcome(msg);
	    c1.setUsername(this.names);
		broadcast(sessions, c1.toJson());
		
	}
	
	private static Gson gson=new Gson();
	@OnMessage
	public void message(Session session ,String json){
		
		contentVo vo=gson.fromJson(json, contentVo.class);
		
		if(vo.getType()==1)
		{
			chat c=new chat();
			c.setContent(this.username, vo.getMsg());
			
			broadcast(sessions, c.toJson());
			
		}else{
			//私聊
			String to=vo.getTo();
			Session to_session=this.map.get(to);
			
			chat c2=new chat();
			c2.setContent(this.username,"<font color=red>"+this.username+"私聊你: "+vo.getMsg()+"</font>");
		
			try {
				to_session.getBasicRemote().sendText(c2.toJson());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
