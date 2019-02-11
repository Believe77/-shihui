package com.meizhuo.dao;

import java.sql.SQLException;

import com.meizhuo.pojo.User;



public interface PersonalMessageDao {

	Object save(User user) throws SQLException ;

}
