package com.meizhuo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meizhuo.dao.ReturnCollectionDao;
import com.meizhuo.pojo.Collection;
import com.meizhuo.service.ReturnCollectionService;

@Service
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class ReturnCollectionServiceImpl implements ReturnCollectionService {

	@Resource
	private ReturnCollectionDao returnCollectionDao;
	 
	
	@Override
	public List<Collection> search() {
		
		return returnCollectionDao.search();
	}

}
