package com.bishe.dao.java;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bishe.pojo.Hot;
import com.bishe.pojo.h_book;
import com.bishe.pojo.h_type;

public interface GetisHotDao {

	List<Hot> findIsHot(String ishot);


	List<h_type> findtype();

	void delete(@Param("t_id")Integer id);

	void add(@Param("type")String type);

	List<h_book> findTypebook(String type);

}
