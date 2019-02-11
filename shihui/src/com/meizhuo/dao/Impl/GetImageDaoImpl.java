package com.meizhuo.dao.Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meizhuo.dao.GetImageDao;
import com.meizhuo.pojo.Topimage;
import com.meizhuo.pojo.User;
import com.meizhuo.utils.MyHibernateDaoSupport;

@Repository("getImageDao")
public class GetImageDaoImpl extends MyHibernateDaoSupport implements GetImageDao{

	@Override
	public List<Topimage> checkImagePath() {
		
        DetachedCriteria dc = DetachedCriteria.forClass(Topimage.class);
		
		
		List<Topimage> list = (List<Topimage>) getHibernateTemplate().findByCriteria(dc);
		
		return list;
		
	}

}
