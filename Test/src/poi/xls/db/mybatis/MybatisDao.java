package poi.xls.db.mybatis;

import org.apache.ibatis.session.SqlSession;

import poi.xls.bean.BankConfig;
import poi.xls.bean.BranchBank;

/**
* @author 作者 louys:
* @version 创建时间：2017年9月15日 上午9:57:23
* 类说明
*/
public class MybatisDao {
	public static final String NAME_SPACE_POIXLS = "PoiXls.";
	private SqlSession session = MybatisSqlSession.getSqlSession();
	
	public Integer insertBankConfig(BankConfig bc){
		Integer result = session.insert("PoiXls.insertBankConfig", bc);
		return result;
	}
	
	public Integer insertBranchBank(BranchBank bb){
		Integer result = session.insert("PoiXls.insertBranchBank", bb);
		return result;
	}
	
	public BankConfig get(Long id){
		BankConfig bc = session.selectOne("PoiXls.getBank", id);
		session.commit();
		session.close();
		return bc;
	}
	
	public void closeSession(){
		this.session.close();
	}
	
	public void commitSession(){
		this.session.commit();
	}
	public static void main(String[] args) {
		MybatisDao dao = new MybatisDao();
		BankConfig bc = new BankConfig();
		bc.setBank_bin_no("123");
		bc.setBank_code("11");
		bc.setBank_name("ssss");
		int i = dao.insertBankConfig(bc);
		System.out.println(i);
	}
}
