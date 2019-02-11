package com.meizhuo.utils;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class MyHibernateDaoSupport extends HibernateDaoSupport{

	@Resource(name="sessionFactory")//Ϊ����HibernateDaoSupportע��sessionFactory��ֵ
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);

	}
	
}
