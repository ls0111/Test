package poi.xls.generator;

import java.io.FileNotFoundException;
import java.util.List;

import poi.xls.bean.BankConfig;
import poi.xls.db.mybatis.MybatisDao;
import poi.xls.service.Poi2BeansService;

/**
* @author 作者 louys:
* @version 创建时间：2017年9月15日 上午10:08:56
* 类说明
*/
public class PoiGenerator {
	private Poi2BeansService poi = new Poi2BeansService();
	private MybatisDao dao = new MybatisDao();
	
	public Integer insert2DB(String file){
		try {
			Integer count = 0;
			List<BankConfig> list = poi.trans2Bean(file);
			for(BankConfig bc:list){
				System.out.println(bc);
				if(dao.insert(bc) == 1){
					count += 1;
				}
			}
			dao.commitSession();
			dao.closeSession();
			return count;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static void main(String[] args) {
		String file = "C:\\Users\\Administrator\\Desktop\\mysql\\全国银行卡卡表(卡BIN).xls";
		PoiGenerator poi = new PoiGenerator();
		System.out.println(poi.insert2DB(file));
	}
}
