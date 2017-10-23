package com.smart.factory;

import com.smart.bean.Car;

/**
* @author 作者 louys:
* @version 创建时间：2017年10月18日 下午1:29:30
* 类说明
*/
public class CarFactory {
	public Car createBugattiCar(){
		Car car = new Car();
		car.setBrand("Bugatti");
		return car;
	}
	
	public static Car createVWCar(){
		Car car = new Car();
		car.setBrand("VW");
		return car;
	}
}
