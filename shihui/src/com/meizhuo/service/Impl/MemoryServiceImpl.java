package com.meizhuo.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meizhuo.dao.MemoryDao;
import com.meizhuo.pojo.window;
import com.meizhuo.service.MemoryService;

@Service
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class MemoryServiceImpl implements MemoryService {

	@Resource
	private MemoryDao memoryDao;
	
	@Override
	public window findWindowNameById(String pid) {
		
		return memoryDao.findWindowNameById(pid);
	}

}
