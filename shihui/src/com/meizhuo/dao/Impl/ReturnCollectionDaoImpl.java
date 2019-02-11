package com.meizhuo.dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.meizhuo.dao.ReturnCollectionDao;
import com.meizhuo.pojo.Collection;
import com.meizhuo.utils.MyHibernateDaoSupport;

@Repository("returnCollectionDao")
public class ReturnCollectionDaoImpl extends MyHibernateDaoSupport implements ReturnCollectionDao {

	@Override
	public List<Collection> search() {
		
        DetachedCriteria dc = DetachedCriteria.forClass(Collection.class);
		
		
		List<Collection> list = (List<Collection>) getHibernateTemplate().findByCriteria(dc);
		
		return list;
		
	}

}
