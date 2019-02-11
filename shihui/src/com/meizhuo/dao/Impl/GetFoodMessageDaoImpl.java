package com.meizhuo.dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.meizhuo.dao.GetFoodMessageDao;
import com.meizhuo.pojo.Foods;
import com.meizhuo.pojo.window;
import com.meizhuo.utils.MyHibernateDaoSupport;

@Repository("getFoodMessageDao")
public class GetFoodMessageDaoImpl extends MyHibernateDaoSupport implements GetFoodMessageDao{

	@Override
	public List<Foods> getFoodMessage(String window_id) {
		
    DetachedCriteria dc = DetachedCriteria.forClass(Foods.class);
		
		
	dc.add(Restrictions.eq("window_id", window_id));
	
	List<Foods> list = (List<Foods>) getHibernateTemplate().findByCriteria(dc);
	return list;
	}

	
}
