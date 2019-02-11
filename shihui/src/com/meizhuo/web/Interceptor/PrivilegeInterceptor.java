package com.meizhuo.web.Interceptor;

import java.util.Map;

import com.meizhuo.pojo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;


public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	//��У���½��ע�᷽��
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//1 ���Session
			Map<String, Object> session = ActionContext.getContext().getSession();
		//2 ��õ�½��ʶ
			User user = (User) session.get("user");
		//3 �жϱ�ʶ�Ƿ����
			if(user != null){
				//����=> ����
				return invocation.invoke();
			}else{
				//������=> �ض��򵽵�½ҳ��
				return "toLogin";
			}
			
	}

}
