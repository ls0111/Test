package poi.xls.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import lys.myutil.StringUtil;

/**
* @author 作者 louys:
* @version 创建时间：2017年9月15日 下午3:35:19
* 类说明
*/
public abstract class Poi2Beans<T> {
	public ExcelReader excelReader = new ExcelReader();
	public abstract T genBeans(String[] arr);
	public List<T> trans2Bean(Map<Integer, String> data) {
		List<T> list = new ArrayList<T>();
		Set<Entry<Integer, String>> entries = data.entrySet();
		for (Entry<Integer, String> e : entries) {
			String[] arr = StringUtil.replaceBlank(e.getValue()).split(",");
			T bc = genBeans(arr);
			list.add(bc);
		}
		return list;
	}
	
}
