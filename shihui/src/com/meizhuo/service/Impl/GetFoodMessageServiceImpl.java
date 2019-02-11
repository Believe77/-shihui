package com.meizhuo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meizhuo.dao.GetFoodMessageDao;
import com.meizhuo.pojo.Foods;
import com.meizhuo.service.GetFoodMessageService;

@Service
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class GetFoodMessageServiceImpl implements GetFoodMessageService {

	@Resource
	private GetFoodMessageDao getFoodMessageDao;
	
	@Override
	public List<Foods> getFoodMessage(String window_id) {
		
		return getFoodMessageDao.getFoodMessage(window_id);
	}

}
