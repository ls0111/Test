package com.smart.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.smart.Car;

/**
* @author 作者 louys:
* @version 创建时间：2017年10月11日 上午9:34:13
* 类说明
*/
public class MyBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if("car".equals(beanName)){
			Car car = (Car)bean;
			if(car.getColor()==null){
				System.out.println("invoke postProcessBeforeInitialization() ,if color is null,set Black!");
				car.setColor("Black");
			}
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if("car".equals(beanName)){
			Car car = (Car)bean;
			if(car.getMaxSpeed()>=200){
				System.out.println("invoke postProcessAfterInitialization() ,if maxSpeed > 200,set 200!");
				car.setMaxSpeed(200);
			}
		}
		return bean;
	}

}
