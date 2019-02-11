package com.meizhuo.service;

import com.meizhuo.pojo.Foods;
import com.meizhuo.pojo.Zhangdang;

public interface BillService {

	Foods find(Integer ch);

	void save(Zhangdang zd);

	void update(Integer food_count, Integer food_id);

}
