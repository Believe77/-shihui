package com.meizhuo.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meizhuo.dao.BillDao;
import com.meizhuo.pojo.Foods;
import com.meizhuo.pojo.Zhangdang;
import com.meizhuo.service.BillService;

@Service
@Transactional
public class BillServiceImpl implements BillService {

	@Resource
	private BillDao billDao;
	
	
	
	@Override
	public void save(Zhangdang zd) {
		billDao.save(zd);

	}



	@Override
	public Foods find(Integer ch) {
		return billDao.find(ch);
	}



	@Override
	public void update(Integer food_count, Integer food_id) {
		
		billDao.update(food_count,food_id);
	}



	

}
