package com.meizhuo.dao.Impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.meizhuo.dao.BillDao;
import com.meizhuo.pojo.Foods;
import com.meizhuo.pojo.User;
import com.meizhuo.pojo.Zhangdang;
import com.meizhuo.service.BillService;
import com.meizhuo.utils.MyHibernateDaoSupport;

@Repository("BillDao")
public class BillDaoImpl extends MyHibernateDaoSupport implements BillDao {

	

	@Override
	public Foods find(final Integer ch) {
		
		return getHibernateTemplate().execute(new HibernateCallback<Foods>() {
			@Override
			public Foods doInHibernate(Session session) throws HibernateException {
				
					String hql = "from Foods where food_id= ? ";
					Query query = session.createQuery(hql);
					query.setParameter(0, ch);
					Foods food = (Foods) query.uniqueResult();
				return food;
			}
		});
	}

	@Override
	public void save(Zhangdang zd) {
		
		getHibernateTemplate().save(zd);
		
	}

	@Override
	public Object update(final Integer food_count,final Integer food_id) {
		
		return getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
					String hql = "Update Foods f set f.food_count=? where f.food_id= ?";
					Query query = session.createQuery(hql);
					query.setParameter(0, food_count);
					query.setParameter(1, food_id);
					int a=query.executeUpdate();
					System.out.println(a);
					
				return null;
			}
		});
		
	}

	
	

}
