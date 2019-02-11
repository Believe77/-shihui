package com.meizhuo.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meizhuo.dao.CollectionDao;
import com.meizhuo.pojo.Collection;
import com.meizhuo.service.CollectionService;

@Service
@Transactional
public class CollectionServiceImpl implements CollectionService {

	@Resource
	private CollectionDao collectionDao;
	
	@Override
	public void save(Collection col) {
		
		collectionDao.save(col);
	}

}
