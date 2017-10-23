package com.smart.bean;

import java.util.Map;
import java.util.Properties;

/**
* @author 作者 louys:
* @version 创建时间：2017年10月18日 上午9:34:45
* 类说明
*/
public class Boss {
	private String name;
	private Car car;
	private Map<String,String> favorites;
	private Properties properties;
	
	public Boss(){
		
	}
	
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
	public Map<String, String> getFavorites() {
		return favorites;
	}
	public void setFavorites(Map<String, String> favorites) {
		this.favorites = favorites;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Boss [name=" + name + ", car=" + car + ", favorites=" + favorites + ", properties=" + properties + "]";
	}
}
