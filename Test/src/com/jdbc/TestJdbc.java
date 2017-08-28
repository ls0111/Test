package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJdbc {
	public static void main(String[] args) throws SQLException {
		PreparedStatement pst = null;
		Connection con = DBUtils.getConnection();
		String sql = "select ?,? from hoyi_user where id=?";
		pst = con.prepareStatement(sql);
		pst.setString(1, "100");
		pst.setString(2, "200");
		pst.setString(3, "400");
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			for (int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {
				System.out.println(rs.getString(j));
			}
		}
	}
}
