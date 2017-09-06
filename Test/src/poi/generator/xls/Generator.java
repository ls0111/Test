package poi.generator.xls;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 数据库表-->Excel表格
 * @author Administrator
 */
public class Generator {
	public static void generate(ResultSet rlts, String path) {
		HSSFWorkbook wb = new HSSFWorkbook();
		// 生成一个sheet1
		HSSFSheet sheet = wb.createSheet("sheet1");
		// 为sheet1生成第一行，用于放表头信息
		HSSFRow row = sheet.createRow(0);

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("序号");

		cell = row.createCell(1);
		cell.setCellValue("字段");

		cell = row.createCell(2);
		cell.setCellValue("数据类型");

		cell = row.createCell(3);
		cell.setCellValue("备注");
		
		cell = row.createCell(4);
		cell.setCellValue("业务说明");

		try {
			int intRow = 1;
			while(rlts.next()){
				HSSFRow rows = sheet.createRow(intRow);

				HSSFCell cell0 = rows.createCell(0);
				cell0.setCellValue(intRow);
				HSSFCell cell1 = rows.createCell(1);
				cell1.setCellValue(rlts.getString("Field"));
				HSSFCell cell2 = rows.createCell(2);
				cell2.setCellValue(rlts.getString("Type"));
				HSSFCell cell3 = rows.createCell(3);
				cell3.setCellValue(rlts.getString("Comment"));
				intRow++;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] content = os.toByteArray();
		// Excel文件生成后存储的位置。
		File file = new File(path);
		OutputStream fos = null;

		try {
			fos = new FileOutputStream(file);
			fos.write(content);
			os.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static ResultSet getData(String tableName){
		return DBUtils.query("SHOW FULL COLUMNS FROM " + tableName);
	}
}
