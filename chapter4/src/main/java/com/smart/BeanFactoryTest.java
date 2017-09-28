package com.smart;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

public class BeanFactoryTest {
    public static void main(String[] args){
        BeanFactoryTest test = new BeanFactoryTest();
        try {
            test.getBean();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getBean() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:beans.xml");
        System.out.println(resource.getURL());
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);

        System.out.println("init beanfactory!");

        Car car = factory.getBean("car1",Car.class);
        System.out.println("car bean is ready for user!");
        System.out.println(car);
    }
}
