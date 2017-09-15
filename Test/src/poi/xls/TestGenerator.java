package poi.xls;

import java.sql.ResultSet;

import poi.xls.generator.Generator;

public class TestGenerator {
	public static void main(String[] args) {
		String tableName = "hoyi_user_certification";
		String path = "C:\\Users\\Administrator\\Desktop\\TODO\\"+tableName+".xls";
		ResultSet rlts = Generator.getData(tableName);
		Generator.generate(rlts, path);
	}
}
