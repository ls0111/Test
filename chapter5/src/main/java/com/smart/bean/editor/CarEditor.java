package com.smart.bean.editor;

import java.beans.PropertyEditorSupport;

import com.smart.bean.Car;

/**
* @author 作者 louys:
* @version 创建时间：2017年11月3日 下午6:46:56
* 类说明
*/
public class CarEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(null == text){
			throw new IllegalArgumentException();
		}
		System.out.println("====="+text);
		String[] info = text.split(",");
		Car car = new Car();
		car.setBrand(info[0]);
		car.setColor(info[1]);
		car.setMaxSpeed(Integer.parseInt(info[2]));
		setValue(car);
	}
	
}
