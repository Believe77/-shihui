package com.meizhuo.chat;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
//����socket
public class democonfig implements ServerApplicationConfig{

	//ע�ⷽʽ ����
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scan) {
		// TODO Auto-generated method stub
		System.out.println("����"+scan.size());
		
		//���� �ṩ�˹��˵�����
		return scan;
	}

	//�ӿڷ�ʽ ����
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
