package cn.lys.context;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import cn.lys.bean.Car;

/**
* @author 作者 louys:
* @version 创建时间：2017年10月17日 下午1:11:46
* 类说明
*/
public class SpringContext {
	public static void main(String[] args) {
		String path = "classpath:smart-context.xml";
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
		
		Car car = (Car) bf.getBean("car");
		System.out.println(car);
		BasicDataSource dataSource = (BasicDataSource) bf.getBean("dataSource");
		System.out.println(dataSource.toString());
		System.out.println(dataSource.getUsername());
	}
}
