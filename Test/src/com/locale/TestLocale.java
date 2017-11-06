package com.locale;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
* @author 作者 louys:
* @version 创建时间：2017年11月6日 上午9:27:21
* 类说明
*/
public class TestLocale {
	public static void main(String[] args) {
		// 数字格式化
		Locale locale = new Locale("zh","CN");
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		double amt = 123456.78;
		System.out.println(nf.format(amt));
		// 时间格式化
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		System.out.println(df.format(new Date()));
		// message格式化，占位符
		// 格式化信息字符串
		String pattern1 = "{0},你好！你于{1}在工商银行存入{2}元。";
		String pattern2 = "At {1,time,short} On {1,date,long}, {0} paid {2,number,currency}.";
		// 用于动态替换占位符的参数
		Object[] params = {"John",new GregorianCalendar().getTime(),1.0E3};
		// 使用默认的本地化对象格式化信息
		String msg1 = MessageFormat.format(pattern1, params);
		// 使用指定的本地化对象格式化信息
		MessageFormat mf = new MessageFormat(pattern2, Locale.US);
		String msg2 = mf.format(params);
		System.out.println(msg1);
		System.out.println(msg2);
	}
}
