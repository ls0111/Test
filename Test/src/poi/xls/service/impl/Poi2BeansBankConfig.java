package poi.xls.service.impl;

import poi.xls.bean.BankConfig;
import poi.xls.service.Poi2Beans;

/**
 * @author 作者 louys:
 * @version 创建时间：2017年9月15日 上午10:09:44 类说明
 */
public class Poi2BeansBankConfig extends Poi2Beans<BankConfig>{
	
	@Override
	public BankConfig genBeans(String[] arr) {
		BankConfig bc = new BankConfig();
		for (int i = 0; i < arr.length; i++) {
			setBankNameCode(arr[0],bc);
			bc.setBank_bin_no(arr[13]);
			bc.setCard_type(arr[15]);
			bc.setNeed_branch_bank("1");
		}
		return bc;
	}

	private void setBankNameCode(String str, BankConfig bc) {
		String[] arr = str.split("\\(|\\)");
		if (arr.length==2) {
			bc.setBank_name(arr[0]);
			bc.setBank_code(arr[1].substring(0, 4));
		}else{
			String name = "";
			for(int i=0;i<arr.length-1;i++){
				name += arr[i];
			}
			bc.setBank_name(name);
			bc.setBank_code(arr[arr.length-1].substring(0, 4));
		}
	}
}
