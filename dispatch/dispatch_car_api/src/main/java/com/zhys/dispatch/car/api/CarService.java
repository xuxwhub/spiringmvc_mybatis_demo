package com.zhys.dispatch.car.api;

import com.zhys.dispatch.car.entity.Car;

public interface CarService {
	
  public String getCarJson(String carStr);
  
  public Car getCar(Car car);
}
