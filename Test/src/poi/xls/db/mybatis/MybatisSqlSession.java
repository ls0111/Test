package poi.xls.db.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import poi.xls.bean.BankConfig;

/**
 * @author 作者 louys:
 * @version 创建时间：2017年9月15日 上午9:19:52 类说明
 */
public class MybatisSqlSession {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static {
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取SQLSession创建工厂
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
	
	public static SqlSession getSqlSession(){
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
	public static void main(String[] args) {
		SqlSession session = getSqlSession();
		BankConfig bc = session.selectOne("PoiXls.getBank", 1);
		System.out.println(bc);
	}
}
