package com.cloneable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sheep implements Cloneable {
	private int id;
	private Date birth;
	private String name;
	private int age;
	private Host host;
	
	public Sheep(int id, Date birth, int age, String name, Host host) {
		super();
		this.id = id;
		this.birth = birth;
		this.age = age;
		this.name = name;
		this.host = host;
	}
	
	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	public int getId() {
		return id;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sheep clone() throws CloneNotSupportedException{
		return (Sheep) super.clone();
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "Sheep [id=" + id + ", birth=" + sdf.format(birth) + ", name=" + name + ", age=" + age + ", host="+host.getId()+ "]";
	}
}
