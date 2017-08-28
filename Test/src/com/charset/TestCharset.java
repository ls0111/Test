package com.charset;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

public class TestCharset {
	public static void main(String[] args) {
		Charset cset = Charset.forName("UTF-8");
		Map map = cset.availableCharsets();
		System.out.println("\uFFFD");
	}
}
