package com.smart.beanfactory;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

/**
* @author 作者 louys:
* @version 创建时间：2017年10月11日 上午9:23:46
* 类说明
*/
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

	//1.接口方法：在实例化bean前调用
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if("car".equals(beanName)){
			System.out.println("invoke postProcessBeforeInstantiation()");
		}
		return super.postProcessBeforeInstantiation(beanClass, beanName);
	}

	//2.接口方法：在实例化bean后调用
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if("car".equals(beanName)){
			System.out.println("invoke postProcessAfterInstantiation()");
		}
		return super.postProcessAfterInstantiation(bean, beanName);
	}

	//3.接口方法：在设置某个属性时调用
	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
			String beanName) throws BeansException {
		if("car".equals(beanName)){
			System.out.println("invoke postProcessPropertyValues()");
		}
		return super.postProcessPropertyValues(pvs, pds, bean, beanName);
	}
	
}
