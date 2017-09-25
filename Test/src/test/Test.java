package test;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		String bindedUserTel = "13571231350";
		String str = bindedUserTel.replaceAll("(\\d{3}).*(\\d{4})", "$1****$2");
		System.out.println(str);
	}
}
