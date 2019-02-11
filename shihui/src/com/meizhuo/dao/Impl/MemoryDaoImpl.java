package com.meizhuo.dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.meizhuo.dao.MemoryDao;
import com.meizhuo.pojo.Foods;
import com.meizhuo.pojo.window;
import com.meizhuo.utils.MyHibernateDaoSupport;

@Repository("findCollectionDao")
public class MemoryDaoImpl extends MyHibernateDaoSupport implements MemoryDao{

	@Override
	public window findWindowNameById(String pid) {
		
		DetachedCriteria dc = DetachedCriteria.forClass(window.class);
		
		
		dc.add(Restrictions.eq("window_id", Integer.valueOf(pid)));
		
		List<window> list = (List<window>) getHibernateTemplate().findByCriteria(dc);
		if(list != null && list.size()>0){
			System.out.println(list.get(0));
			return list.get(0);
		}else{
			return null;
		}
		
	}

	
}
