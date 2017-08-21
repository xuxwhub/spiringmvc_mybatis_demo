package com.zhys.dispatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhys.dispatch.car.api.CarService;
import com.zhys.dispatch.car.entity.Car;
import com.zhys.dispatch.repository.CarMapper;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarMapper carMapper;

	@Override
	public String getCarJson(String carId) {
		Car car = carMapper.selectByPrimaryKey(Integer.parseInt(carId));
		return car.getDriverNo();
	}

	@Override
	public Car getCar(Car car) {
		return null;
	}

}
