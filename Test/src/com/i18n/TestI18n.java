package com.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
* @author 作者 louys:
* @version 创建时间：2017年11月7日 上午9:13:00
* 类说明
*/
public class TestI18n {
	public static void main(String[] args) {
		// 不需要classpath:   "."与"/"通用
		ResourceBundle rb1 = ResourceBundle.getBundle("i18n/greet", Locale.CHINA);
		ResourceBundle rb2 = ResourceBundle.getBundle("i18n.greet", Locale.US);
		System.out.println(rb1.getString("greeting.commons"));
		System.out.println(rb2.getString("greeting.commons"));
	}
}
