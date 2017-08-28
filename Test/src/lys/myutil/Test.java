package lys.myutil;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		System.out.println(IOUtil.read(SystemUtil.getFileCatalog(Test.class)));
	}
}
