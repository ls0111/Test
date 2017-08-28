package com.io;

import java.io.IOException;

import lys.myutil.IOUtil;
import lys.myutil.SystemUtil;

public class ReadBinaryFile {
	public static void main(String[] args) {
		String filename = SystemUtil.getCurrentCatalog(ReadBinaryFile.class)+"/test.dat";
		try {
			String data = IOUtil.format(IOUtil.readFile2Bytes(filename));
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
