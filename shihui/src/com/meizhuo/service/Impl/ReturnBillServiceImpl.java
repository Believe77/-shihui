package com.meizhuo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meizhuo.dao.ReturnBillDao;
import com.meizhuo.pojo.Zhangdang;
import com.meizhuo.service.ReturnBillService;

@Service
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class ReturnBillServiceImpl implements ReturnBillService {

	@Resource
	private ReturnBillDao returnBillDao;

	@Override
	public List<Zhangdang> find(String user) {
		
		return returnBillDao.find(user);
	}

	

	
	
	

	

}
