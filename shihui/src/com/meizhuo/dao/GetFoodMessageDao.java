package com.meizhuo.dao;

import java.util.List;

import com.meizhuo.pojo.Foods;

public interface GetFoodMessageDao {

	List<Foods> getFoodMessage(String window_id);

}
