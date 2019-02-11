package com.meizhuo.dao.Impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.meizhuo.dao.UserPictureDao;
import com.meizhuo.pojo.User;
import com.meizhuo.utils.MyHibernateDaoSupport;

@Repository("UserPictureDao")
public class UserPictureDaoImpl  extends MyHibernateDaoSupport implements UserPictureDao{

	@Override
	public Object save(final String path,final User u2) {
		
		return getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				
				String sql="update user set user_path='"+path+"'where user_code= '"+u2.getUser_code()+"'";

				session.createSQLQuery(sql).executeUpdate();
				return null;
				
			}
		});
	
		
	}
		
		
}

	
	

