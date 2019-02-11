package com.meizhuo.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meizhuo.dao.SumDao;
import com.meizhuo.pojo.Sum;
import com.meizhuo.service.SumService;

@Service
@Transactional
public class SumServiceImpl implements SumService {

	@Resource
	private SumDao sumDao;
	
	

	@Override
	public void save(Sum s) {
		
		sumDao.save(s);
		
	}


}
