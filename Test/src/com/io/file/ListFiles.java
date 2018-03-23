package com.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import lys.myutil.StringUtil;

public class ListFiles {
	public static void main(String[] args) {
		String path = ".";
		listFiles(path, "properties");
	}
	
	public static void listFiles(String path, String suffix) {
		try {
			File pathname = new File(path);
			String[] filenames = pathname.list(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					System.out.println(name);
					if(StringUtil.isBlank(suffix) || name.endsWith(suffix)){
						return true;
					}
					return false;
				}
			});
			for (String fname : filenames) {
				File file = new File(pathname.getPath(),fname);
				if (file.isDirectory()) {
					System.out.println(file.getCanonicalPath());
					listFiles(file.getPath(), suffix);
				} else {
					System.out.println(file.getName());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
