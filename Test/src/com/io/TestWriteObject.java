package com.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lys.myutil.SystemUtil;

public class TestWriteObject {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String file = SystemUtil.getCurrentCatalog(TestWriteObject.class)+"\\test.dat";
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
		Dog dog = new Dog("hudy", 12);
		Dog dog2 = new Dog("wudy", 10);
		os.writeObject(dog);
		os.writeObject(dog2);
		os.close();
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
		Object o1 = is.readObject();
		Object o2 = is.readObject();
		System.out.println(o1.getClass().getName());
		System.out.println(o2.getClass().getName());
		is.close();
	}
}
class Dog implements Serializable {
	private static final long serialVersionUID = -2655604771573052600L;
	private String name;
	private int age;
	
	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}