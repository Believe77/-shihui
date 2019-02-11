package com.meizhuo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meizhuo.dao.GetWindowNameDao;
import com.meizhuo.pojo.window;
import com.meizhuo.service.GetWindowNameService;

@Service
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class GetWindowNameServiceImpl implements GetWindowNameService {

	@Resource
	private GetWindowNameDao getWindowNameDao;
	
	@Override
	public List<window> checkWindowName(String carteen_id) {
		
		return getWindowNameDao.checkWindowName(carteen_id);
	}

}
