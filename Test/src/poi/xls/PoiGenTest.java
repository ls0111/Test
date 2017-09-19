package poi.xls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import poi.xls.bean.BranchBank;
import poi.xls.db.mybatis.MybatisDao;
import poi.xls.service.impl.Poi2BeansBranchBank;

/**
* @author 作者 louys:
* @version 创建时间：2017年9月15日 下午3:42:45
* 类说明
*/
public class PoiGenTest {
	public static void main(String[] args) {
		Poi2BeansBranchBank poi = new Poi2BeansBranchBank();
		MybatisDao dao = new MybatisDao();
//		String file = "C:\\Users\\Administrator\\Desktop\\mysql\\全国银行卡卡表(卡BIN).xls";
		String file = "C:\\Users\\Administrator\\Desktop\\mysql\\全国银行行号及中行联行号2.xls";
		try {
			Map<Integer,String> data = poi.excelReader.readExcelContent(new FileInputStream(file));
			List<BranchBank> list = poi.trans2Bean(data);
			int count = 0;
			for(BranchBank bb:list){
				if(dao.insertBranchBank(bb) == 1){
					count++;
				}
			}
			dao.commitSession();
			dao.closeSession();
			System.out.println(count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
