package com.smart.bean;
/**
* @author 作者 louys:
* @version 创建时间：2017年10月17日 下午1:08:48
* 类说明
*/
public class Car {
	private Boss boss;
	private String brand;
	private String color;
	private int maxSpeed;
	
	public Car(){
		
	}
	
	public Car(String color){
		this.color = color;
	}
	
	public Car(Boss boss, String brand){
		this.boss = boss;
		this.brand = brand;
	}
	
	public Boss getBoss() {
		return boss;
	}
	public void setBoss(Boss boss) {
		this.boss = boss;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}
}
