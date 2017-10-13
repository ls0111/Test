package com.smart.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.smart.Car;

/**
* @author 作者 louys:
* @version 创建时间：2017年10月11日 上午9:43:20
* 类说明
*/
public class BeanLifeCycle {
	private static void lifeCycleInBeanFactory(){
		// 1.装在配置文件并启动容器
		Resource resource = new ClassPathResource("/beans.xml");
		BeanFactory bf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory)bf);
		reader.loadBeanDefinitions(resource);
		
		// 2.向容器中配置MyBeanPostProcessor后处理器
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());
		// 3.向容器中配置MyInstantiationAwareBeanPostProcessor后处理器
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		
		// 4.第一次从容器中获取car，将触发容器实例化该bean，这将引发bean生命周期方法调用
		Car car1 = (Car) bf.getBean("car");
		car1.introduce();
		car1.setColor("红色");
		
		// 5.第二次从容器中获取car，直接从缓存池中获取
		Car car2 = (Car) bf.getBean("car");
		
		// 6.查看car1和car2是否指向同一个引用
		System.out.println("car1==car2:"+(car1==car2));
		
		// 7.关闭容器
		((DefaultListableBeanFactory)bf).destroySingletons();
	}
	public static void main(String[] args) {
		lifeCycleInBeanFactory();
	}
}
