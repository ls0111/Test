package com.smart.bean;
/**
* @author 作者 louys:
* @version 创建时间：2017年10月18日 上午9:34:45
* 类说明
*/
public class Boss {
	private String name;
	private Car car;
	
	public Boss(String name,Car car){
		this.name = name;
		this.car = car;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
}
