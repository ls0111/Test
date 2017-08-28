package com.serializable;

import java.io.Serializable;
import java.util.Date;

public class People implements Serializable {
	private static final long serialVersionUID = 2170254176416333570L;

	private String name;
	private int age;
	private Date birthday;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
	}
}
