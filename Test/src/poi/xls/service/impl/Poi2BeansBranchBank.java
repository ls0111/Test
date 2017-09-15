package poi.xls.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import lys.myutil.StringUtil;
import poi.xls.bean.BankConfig;
import poi.xls.bean.BranchBank;
import poi.xls.service.Poi2Beans;

/**
 * @author 作者 louys:
 * @version 创建时间：2017年9月15日 上午10:09:44 类说明
 */
public class Poi2BeansBranchBank implements Poi2Beans<BranchBank>{
	@Override
	public List<BranchBank> trans2Bean(Map<Integer, String> data) {
		List<BranchBank> list = new ArrayList<BranchBank>();
		Set<Entry<Integer, String>> entries = data.entrySet();
		for (Entry<Integer, String> e : entries) {
			String[] arr = StringUtil.replaceBlank(e.getValue()).split(",");
			BranchBank bc = genBeans(arr);
			list.add(bc);
		}
		return list;
	}

	private BranchBank genBeans(String[] arr) {
		BranchBank bb = new BranchBank();
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			bb.setBank_name(arr[0]);
			bb.setBank_code("0"+arr[2]);
			bb.setProvince(arr[8]);
			bb.setCity(arr[7]);
			bb.setDistrict(arr[5]);
		}
		return bb;
	}
}
