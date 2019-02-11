package com.meizhuo.dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.meizhuo.dao.GetWindowNameDao;

import com.meizhuo.pojo.window;
import com.meizhuo.utils.MyHibernateDaoSupport;

@Repository("getNameWindowDao")
public class GetWindowNameDaoImpl extends MyHibernateDaoSupport implements GetWindowNameDao {

	@Override
	public List<window> checkWindowName(String carteen_id) {
		
        DetachedCriteria dc = DetachedCriteria.forClass(window.class);
		
		
		dc.add(Restrictions.eq("carteen_id", carteen_id));
		
		List<window> list = (List<window>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}

}
