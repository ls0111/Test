package cn.lys.editor;

import java.beans.PropertyEditorSupport;

/**
* @author 作者 louys:
* @version 创建时间：2017年11月3日 上午9:38:49
* 类说明
*/
public class TitlePositionEditor extends PropertyEditorSupport {
	private String[] options = {"Left","Center","Right"};
	
	// 1.代表可选字符串
	public String[] getTags(){
		return options;
	}
	
	// 2.代表初始值
	public String getJavaInitializationString(){
		return "" + getValue();
	}
	
	// 3.将内部属性值转换为字符串
	public String getAsText(){
		int value = (Integer) getValue();
		return options[value];
	}
	
	// 4.将外部设置的字符串转换为内部属性值
	public void setAsText(String s){
		for(int i=0;i<options.length;i++){
			if(options[i].equals(s)){
				setValue(i);
				return;
			}
		}
	}
}
