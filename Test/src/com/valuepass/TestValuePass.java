package com.valuepass;

public class TestValuePass {
	public static void main(String[] args) {
		Apple a1 = new Apple(10);
		Apple a2 = new Apple(20);
		swap(a1,a2);
		System.out.println("Apple-1=="+a1.getSize());
		System.out.println("Apple-2=="+a2.getSize());
	}
	private static void swap(Apple a1,Apple a2){
		Apple temp = a1;
		a1 = a2;
		a2 = temp;
	}
}
class Apple{
	private int size;

	public Apple(int size) {
		super();
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}