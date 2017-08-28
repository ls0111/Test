package com.extendz;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class TestExtends {
	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Biology b = new Animal();
		b.eat();
	}
}
