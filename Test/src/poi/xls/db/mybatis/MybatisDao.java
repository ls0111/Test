package poi.xls.db.mybatis;

import org.apache.ibatis.session.SqlSession;

import poi.xls.bean.BankConfig;

/**
* @author 作者 louys:
* @version 创建时间：2017年9月15日 上午9:57:23
* 类说明
*/
public class MybatisDao {
	public static final String NAME_SPACE_POIXLS = "PoiXls.";
	private SqlSession session = MybatisSqlSession.getSqlSession();
	
	public Integer insert(BankConfig bc){
		Integer result = session.insert("PoiXls.insert", bc);
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
		int i = dao.insert(bc);
		System.out.println(i);
	}
}
