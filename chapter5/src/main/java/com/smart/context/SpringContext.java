package com.smart.context;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.smart.bean.Car;

/**
* @author 作者 louys:
* @version 创建时间：2017年10月17日 下午1:11:46
* 类说明
*/
public class SpringContext {
	public static void main(String[] args) {
		String path = "classpath:beans.xml";
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource res = resolver.getResource(path);
		DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
		reader.loadBeanDefinitions(res);
		
		Car car = (Car) bf.getBean("car3");
		System.out.println(car);
	}
}
