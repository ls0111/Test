package com.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {
	public static void main(String[] args) throws IOException {
		RandomAccessFile file = new RandomAccessFile("E:/workspace/Test/src/source/test.txt", "r");
		System.out.println(file.readUTF());
		System.out.println(file.readChar());
		file.close();
	}
}	
