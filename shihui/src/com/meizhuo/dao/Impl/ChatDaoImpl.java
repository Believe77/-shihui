package com.meizhuo.dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.meizhuo.dao.ChatDao;
import com.meizhuo.pojo.Chat;
import com.meizhuo.pojo.Topimage;
import com.meizhuo.utils.MyHibernateDaoSupport;

@Repository("ChatDao")
public class ChatDaoImpl extends MyHibernateDaoSupport implements ChatDao{

	@Override
	public void save(Chat c) {
		
		getHibernateTemplate().save(c);
	}

	@Override
	public List<Chat> find() {
		
        DetachedCriteria dc = DetachedCriteria.forClass(Chat.class);
		
		List<Chat> list = (List<Chat>) getHibernateTemplate().findByCriteria(dc);
		
		return list;
		
	}

	
	
}
