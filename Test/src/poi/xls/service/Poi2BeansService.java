package poi.xls.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import lys.myutil.StringUtil;
import poi.xls.bean.BankConfig;

/**
 * @author 作者 louys:
 * @version 创建时间：2017年9月15日 上午10:09:44 类说明
 */
public class Poi2BeansService {
	private ExcelReader excelReader = new ExcelReader();

	public List<BankConfig> trans2Bean(String file) throws FileNotFoundException {
		List<BankConfig> list = new ArrayList<BankConfig>();
		Map<Integer, String> map = excelReader.readExcelContent(new FileInputStream(file));
		Set<Entry<Integer, String>> entries = map.entrySet();
		for (Entry<Integer, String> e : entries) {
			String[] arr = StringUtil.replaceBlank(e.getValue()).split(",");
			BankConfig bc = genBeans(arr);
			list.add(bc);
		}
		return list;
	}

	private BankConfig genBeans(String[] arr) {
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

	public static void main(String[] args) {
		Poi2BeansService poi = new Poi2BeansService();
		String file = "C:\\Users\\Administrator\\Desktop\\mysql\\全国银行卡卡表(卡BIN).xls";
		// String file =
		// "C:\\Users\\Administrator\\Desktop\\mysql\\全国银行行号及中行联行号.xls";
		try {
			poi.trans2Bean(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
