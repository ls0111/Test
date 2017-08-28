package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestReflection {
	public static void main(String[] args) {
		Class c = Double.class;
		try {
			printClassInfo(c.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void printClassInfo(String className) throws ClassNotFoundException{
		Class c = Class.forName(className);
		System.out.print(Modifier.toString(c.getModifiers())+" "+c.getSimpleName());
		if(c.getSuperclass()!=null&&c.getSuperclass()!=Object.class){
			System.out.println(" extends "+c.getSuperclass().getName()+"{");
		}
		Field[] fields = c.getDeclaredFields();
		for(Field f:fields){
			System.out.println("	"+Modifier.toString(f.getModifiers())+" "+f.getType().getName()+" "+f.getName()+";");
		}
		System.out.println();
		Constructor[] cons = c.getConstructors();
		for(Constructor con:cons){
			System.out.println("	"+Modifier.toString(con.getModifiers())+" "+con.getName()+"("+con.getParameterTypes().getClass().getName()+");");
		}
		System.out.println();
		Method[] methods = c.getDeclaredMethods();
		for(Method m:methods){
			System.out.println("	"+Modifier.toString(m.getModifiers())+" "+m.getReturnType().getName()+" "+m.getName()+"("+m.getParameterTypes().getClass().getName()+");");
		}
		System.out.println();
		System.out.println("}");
	}
}
