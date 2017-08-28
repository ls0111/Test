package poi.generator.xls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库连接工具类
 * @author zhaorq
 * @verion 1.0.0.1
 */
public class DBUtils {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT a.code dict_type, a.name type_name, b.code item_code, b.name item_name ");
		sb.append("FROM hoyi_dict_type a, hoyi_dict_item b ");
		sb.append("WHERE a.code = b.type ");
		sb.append("ORDER BY a.seqno, b.seqno ");
		ResultSet rs = DBUtils.query(sb.toString());
		try {
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 获得数据库链接
	 * @return
	 */
    public static Connection getConnection() {
    	Connection connection = null;
    	String url = "jdbc:mysql://localhost:3306/jcrcb";
    	String username = "root";
    	String password = "1234";
        try {
        	connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return connection;
    }
    
    public static ResultSet query(String sql) {
    	Connection connection = getConnection();
    	
    	try {
			Statement stmt = connection.createStatement();
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public static ResultSet query(String sql, Object... params) {
    	Connection conn = null;
    	PreparedStatement stmt = null;
    	try {
    		conn = getConnection();
    		stmt = conn.prepareStatement(sql);
    		if (params.length > 0) {
    			for (int i=0; i<params.length; i++) {
    				stmt.setObject(i+1, params[i]);
    			}
    		}
			return stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }

}
