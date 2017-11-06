package cn.lys.props;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import cn.lys.utils.DESUtil;

public class EncryptProps extends PropertyPlaceholderConfigurer {
	private String[] encryptPropsNames = {"jdbc.username","jdbc.password"};
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		System.out.println("&*^(*&^(^(*^*(^*(^*(");
		if(isDecrypt(propertyName)){
			String value = DESUtil.getDecryptStr(propertyValue);
			System.out.println(propertyName+"=="+value);
			return value;
		}
		return propertyValue;
	}
	
	private boolean isDecrypt(String name){
		for(String s:encryptPropsNames){
			if(name.equals(s)){
				return true;
			}
		}
		return false;
	}
}
