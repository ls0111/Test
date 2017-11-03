package com.smart.injectfun;
/**
* @author 作者 louys:
* @version 创建时间：2017年10月17日 下午1:08:48
* 类说明
*/
public class Car {
	private MagicBoss magicBoss;
	private String brand;
	private String color;
	private int maxSpeed;
	
	public Car(){
		
	}
	
	public Car(String color){
		this.color = color;
	}
	
	public Car(MagicBoss magicBoss, String brand){
		this.magicBoss = magicBoss;
		this.brand = brand;
	}
	
	public MagicBoss getMagicBoss() {
		return magicBoss;
	}
	public void setMagicBoss(MagicBoss magicBoss) {
		this.magicBoss = magicBoss;
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
