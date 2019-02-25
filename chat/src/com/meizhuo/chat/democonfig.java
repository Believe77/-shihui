package com.meizhuo.chat;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
//启动socket
public class democonfig implements ServerApplicationConfig{

	//注解方式 启动
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scan) {
		// TODO Auto-generated method stub
		System.out.println("启动"+scan.size());
		
		//返回 提供了过滤的作用
		return scan;
	}

	//接口方式 启动
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
