package com.bishe.service;

import java.util.List;

import com.bishe.pojo.Hot;
import com.bishe.pojo.h_book;

public interface GetisHotService {

	List<Hot> findIsHot(String ishot);


	List<com.bishe.pojo.h_type> findtype();

	void delete(Integer id);

	void add(String type);

	List<h_book> findTypebook(String type);

}
