package com.meizhuo.dao.Impl;

import org.springframework.stereotype.Repository;

import com.meizhuo.dao.CollectionDao;
import com.meizhuo.pojo.Collection;
import com.meizhuo.utils.MyHibernateDaoSupport;

@Repository("collectionDao")
public class CollectionDaoImpl extends MyHibernateDaoSupport implements CollectionDao {

	@Override
	public void save(Collection col) {
		getHibernateTemplate().save(col);

	}

}
