package com.smart.context;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.smart.bean.Boss;
import com.smart.bean.Car;

/**
* @author 作者 louys:
* @version 创建时间：2017年10月17日 下午1:11:46
* 类说明
*/
public class SpringContext {
	public static void main(String[] args) {
		String path = "classpath:beans.xml";
		// 定义资源处理器
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		// 简历资源映射
		Resource res = resolver.getResource(path);
		// 创建javaBean 工厂
		DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
		// xmlBean定义读取器
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
		// 加载bean资源到bean工厂
		reader.loadBeanDefinitions(res);
		
//		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:beans.xml");
//		Car car = (Car) bf.getBean("car6");
//		System.out.println(car);
		Boss boss = (Boss) bf.getBean("boss3");
		System.out.println(boss);
//		Boss boss = (Boss) ac.getBean("boss3");
//		System.out.println(boss);
	}
}
