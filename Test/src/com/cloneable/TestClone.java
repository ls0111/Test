package com.cloneable;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class TestClone {
	public static void main(String[] args) throws CloneNotSupportedException {
		Host host = new Host(1);
		Sheep s = new Sheep(1, new Date(), 0, "doly", host);
		Sheep clone = s.clone();
		System.out.println("s="+s);
		System.out.println("clone="+clone);
		s.setAge(100);
		System.out.println("----------修改age----------");
		System.out.println("s="+s);
		System.out.println("clone="+clone);
		s.setBirth(DateUtils.addDays(s.getBirth(), 10));
		System.out.println("----------修改birth----------");
		System.out.println("s="+s);
		System.out.println("clone="+clone);
		s.setName("doly2");
		System.out.println("----------修改name----------");
		System.out.println("s="+s);
		System.out.println("clone="+clone);
		Host h = new Host(99);
		s.getHost().setId(999);;
		System.out.println("----------修改host----------");
		System.out.println("s="+s);
		System.out.println("clone="+clone);
		
	}
}
