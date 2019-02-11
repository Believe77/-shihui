package com.bishe.dao.java;

import org.apache.ibatis.annotations.Param;

import com.bishe.pojo.NovelType;
import com.bishe.pojo.Shelf;

public interface SaveBookDao {

	NovelType findBook(Integer bid);

	void saveBook(Shelf s);

	Integer findCount(Integer bid2);


	void saveCount(@Param("countRead")Integer cishu,@Param("bid") Integer bid2);

	NovelType find(String bid);

	String ask(@Param("id")Integer id);

}
