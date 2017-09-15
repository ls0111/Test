package com.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import poi.xls.service.ExcelReader;

public class TestJdbc {
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		String file = "C:\\Users\\Administrator\\Desktop\\mysql\\银联支持中小银行.xls";
		ExcelReader reader = new ExcelReader();
		Map<Integer, String> data = reader.readExcelContent(new FileInputStream(file));
		List<String> list = new ArrayList<String>();
		for(Entry<Integer, String> e:data.entrySet()){
			System.out.println(e.getValue().replaceAll(",", ""));
			String value = e.getValue().replaceAll(",", "");
			if(StringUtils.isNotBlank(value)){
				list.add(value);
			}
		}
		System.out.println(list);
		System.out.println(updateAllBank(list));
	}
	
	public static Integer updateAllBank(List<String> bankNames) throws SQLException{
		int num = 0;
		if(null == bankNames){
			return -1;
		}
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		Connection con = DBUtils.getConnection();
		for(String s:bankNames){
			String sql = "select * from hoyi_bank_config bc left join hoyi_branch_bank bb on bc.bank_code=bb.bank_code where bc.bank_name like ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+s+"%");
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				int count = rs.getMetaData().getColumnCount();
				if(null ==rs.getString(count)){
					System.out.println("银行："+s+"===行别代码："+rs.getString(2));
					String uql = "update hoyi_branch_bank set bank_code = ? where bank_name like ?;";
					pst2 = con.prepareStatement(uql);
					pst2.setString(1, rs.getString(2));
					pst2.setString(2, "%"+s+"%");
					num = pst2.executeUpdate();
					break;
				}
			}
		}
		con.close();
		return num;
	}
}
