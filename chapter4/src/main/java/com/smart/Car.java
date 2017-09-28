package com.smart;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//1 管理bean生命周期接口
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
	private String brand;
	private String color;
	private String maxSpeed;

	private BeanFactory beanFactory;
	private String beanName;

	public Car(){
		System.out.println("invoke Car() constructor!");
	}
	public void destroy() throws Exception {
		// TODO Auto-generated method stub

	}

	// 4.InitializingBean接口方法
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	// 3.BeanNameAware接口方法
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub

	}

	// 2 BeanFactoryAware接口方法
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub

	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		System.out.println("invoke setBrand(),set properties!");
		this.brand = brand;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public String introduce() {
		return "Car{" + "brand='" + brand + '\'' + ", color='" + color + '\'' + ", maxSpeed='" + maxSpeed + '\'' + '}';
	}
}
