package com.meizhuo.dao;

import com.meizhuo.pojo.Foods;
import com.meizhuo.pojo.Zhangdang;

public interface BillDao {

	Foods find(Integer ch);

	void save(Zhangdang zd);

	Object update(Integer food_count, Integer food_id);

}
