package com.io.file;

import java.io.File;
import java.io.IOException;

public class ListFiles {
	public static void main(String[] args) {
		String path = ".";
		listFiles(path);
	}
	
	public static void listFiles(String path) {
		try {
			File pathname = new File(path);
			String[] filenames = pathname.list();
			for (String fname : filenames) {
				File file = new File(pathname.getPath(),fname);
				if (file.isDirectory()) {
					System.out.println(file.getCanonicalPath());
					listFiles(file.getPath());
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
