package com.extendz;

public class Animal extends Biology{
	private Double weight;
	@Override
	public void eat(){
		System.out.println("Animal---eat()");
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
}
