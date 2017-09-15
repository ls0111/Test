package poi.xls.service;

import java.util.List;
import java.util.Map;

/**
* @author 作者 louys:
* @version 创建时间：2017年9月15日 下午3:35:19
* 类说明
*/
public interface Poi2Beans<T> {
	public ExcelReader excelReader = new ExcelReader();
	public List<T> trans2Bean(Map<Integer,String> data);
}
