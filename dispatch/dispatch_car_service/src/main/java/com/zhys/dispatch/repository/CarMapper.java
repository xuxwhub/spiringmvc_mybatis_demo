package com.zhys.dispatch.repository;

import com.zhys.dispatch.car.entity.Car;


@MyBatisRepository
public interface CarMapper {
	
    int deleteByPrimaryKey(Integer carId);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer carId);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
}