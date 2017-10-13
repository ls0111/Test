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
	private Integer maxSpeed;

	private BeanFactory beanFactory;
	private String beanName;

	public Car(){
		System.out.println("2. invoke Car() constructor!");
	}
	// DisposableBean接口方法
	public void destroy() throws Exception {
		System.out.println("invoke DisposableBean.destroy()");
	}

	// 4.InitializingBean接口方法
	public void afterPropertiesSet() throws Exception {
		System.out.println("8. invoke InitializingBean.afterPropertiesSet()");
	}

	// 3.BeanNameAware接口方法
	public void setBeanName(String beanName) {
		System.out.println("6. invoke BeanNameAware.setBeanName()");
		this.beanName=beanName;
	}

	// 2 BeanFactoryAware接口方法
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("7. invoke BeanFactoryAware.setBeanFactory()");
		this.beanFactory=beanFactory;
	}
	
	// 通过<bean>的init-method，调用初始化方法
	public void myInit(){
		System.out.println("9. invode init-method，set maxSpeed=240");
		this.maxSpeed=240;
	}
	
	// 通过<bean>的destroy-method，调用销毁方法
	public void myDestroy(){
		System.out.println("invode destroy-method");
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		System.out.println("3. invoke setBrand(),set properties!");
		this.brand = brand;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		System.out.println("4. setColor");
		this.color = color;
	}
	
	public Integer getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(Integer maxSpeed) {
		System.out.println("5. setspeed");
		this.maxSpeed = maxSpeed;
	}
	
	public String introduce() {
		return "Car{" + "brand='" + brand + '\'' + ", color='" + color + '\'' + ", maxSpeed='" + maxSpeed + '\'' + '}';
	}
}
