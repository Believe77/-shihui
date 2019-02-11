package com.meizhuo.dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.meizhuo.dao.ReturnBillDao;
import com.meizhuo.pojo.Collection;
import com.meizhuo.pojo.Zhangdang;
import com.meizhuo.utils.MyHibernateDaoSupport;

@Repository("ReturnBillDao")
public class ReturnBillDaoImpl extends MyHibernateDaoSupport implements ReturnBillDao{


	@Override
	public List<Zhangdang> find(String user) {
		
		
        DetachedCriteria dc = DetachedCriteria.forClass(Zhangdang.class);
		
		dc.add(Restrictions.eq("zhang_user", user));
		
		List<Zhangdang> list = (List<Zhangdang>) getHibernateTemplate().findByCriteria(dc);
		
		return list;
		
		
	}

}
