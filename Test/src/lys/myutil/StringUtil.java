package lys.myutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
* @author 作者 louys:
* @version 创建时间：2017年9月15日 上午11:35:23
* 类说明
*/
public class StringUtil {
	public static String replaceBlank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
	
	public static boolean isBlank(String str){
		return StringUtils.isBlank(str);
	}
	
	public static boolean isNotBlank(String str){
		return !isBlank(str);
	}
}
