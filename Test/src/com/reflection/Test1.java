package com.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test1 {
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Dog d = new Dog();
		Class c = d.getClass();
		Method m = c.getMethod("f", String.class);
		System.out.println(m.invoke(null, "d"));
	}
}
class Dog{
	public static String f(String p){
		return "www"+p;
	}
}
