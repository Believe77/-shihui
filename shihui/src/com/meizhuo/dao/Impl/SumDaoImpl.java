package com.meizhuo.dao.Impl;

import org.springframework.stereotype.Repository;

import com.meizhuo.dao.SumDao;
import com.meizhuo.pojo.Sum;
import com.meizhuo.utils.MyHibernateDaoSupport;

@Repository("SumDao")
public class SumDaoImpl extends MyHibernateDaoSupport implements SumDao {


	@Override
	public void save(Sum s) {
		
		getHibernateTemplate().save(s);
		
	}

}
