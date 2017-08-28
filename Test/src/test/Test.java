package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

public class Test {
	public static void main(String[] args) throws IOException {
		Map<String,Object> map1 = new HashMap<String, Object>();
		map1.put("name", "lys");
		map1.put("age", "18");
		map1.put("tel", "110");
		Map<String,Object> map2 = new HashMap<String, Object>();
		map2.put("name", "sss");
		map2.put("age", "20");
		map2.put("tel", "119");
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(map1);
		list.add(map2);
		System.out.println(JSONArray.fromObject(list).toString());
	}
}
