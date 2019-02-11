package com.meizhuo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meizhuo.dao.GetImageDao;
import com.meizhuo.pojo.Topimage;
import com.meizhuo.service.GetImageService;

@Service
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class GetImageServiceImpl implements GetImageService {

	@Resource
	private GetImageDao getImageDao;
	
	@Override
	public List<Topimage> checkImagePath() {
		
		return getImageDao.checkImagePath();
	}

}
