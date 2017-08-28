package com.json;

import java.util.Date;

import net.sf.json.JSONObject;

public class TestJson {
	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		obj.put("name", "lys");
		obj.put("age", 11);
		String json = obj.toString();
		System.out.println(json);
		JSONObject o = JSONObject.fromObject(json);
		o.put("birth", new Date());
		System.out.println(o.toString());
	}
}
