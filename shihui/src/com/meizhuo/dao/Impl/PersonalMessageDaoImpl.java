package com.meizhuo.dao.Impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.meizhuo.dao.PersonalMessageDao;
import com.meizhuo.pojo.User;
import com.meizhuo.utils.DataSourceUtils;
import com.meizhuo.utils.MyHibernateDaoSupport;

@Repository("personalMessageDao")
public class PersonalMessageDaoImpl extends MyHibernateDaoSupport implements PersonalMessageDao {

	@Override
	public Object save(final User user) throws SQLException {
		
		return getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				String user_address=user.getUser_address();
				String user_code=user.getUser_code();
				String user_sex=user.getUser_sex();
				String user_name=user.getUser_name();
				String user_phone=user.getUser_phone();
				
				String sql="update user set user_address='"+user_address+"',"
						+ "user_name='"+user_name+"',user_sex='"+user_sex+"',user_phone='"+user_phone+"' where user_code='"+user_code+"'";

				session.createSQLQuery(sql).executeUpdate();
				return null;
				
			}
		});
	
		
	}

}
