package lys.myutil;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class IOUtil {
	/**
	 * 把目标数据读取为字符串
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static String read(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = in.readLine()) != null)
			sb.append(s + "\n");
		in.close();
		return sb.toString();
	}
	
	/**
	 * 读取文件为字节数组
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static byte[] readFile2Bytes(String filename) throws IOException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(filename)));
		byte[] data = new byte[in.available()];
		in.read(data);
		in.close();
		return data;
	}
	
	/**
	 * 格式化二进制文件
	 * @param data
	 * @return
	 */
	public static String format(byte[] data) {
		StringBuilder result = new StringBuilder();
		int n = 0;
		for (byte b : data) {
			if (n % 16 == 0) {
				result.append(String.format("%05X: ", n));
			} 
			result.append(String.format("%02X ", b));
			n++;
			if (n % 16 == 0){
				result.append("\n");
			}
		}
		result.append("\n");
		return result.toString();
	}
}
