package cn.lys.utils;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

public class DESUtil {
	private static Key key;
	private static String KEY_STR = "lys0111";
	// 初始化密钥
	static {
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("DES");
			keyGen.init(new SecureRandom(KEY_STR.getBytes()));
			key = keyGen.generateKey();
			keyGen = null;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 加密
	 * @param str
	 * @return
	 */
	public static String getEncryptStr(String str){
		try {
			byte[] bytes = str.getBytes("UTF-8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(bytes);
			return Base64.getEncoder().encodeToString(encryptStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 解密
	 * @param str
	 * @return
	 */
	public static String getDecryptStr(String str){
		try {
			byte[] bytes = Base64.getDecoder().decode(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrBytes = cipher.doFinal(bytes);
			return new String(decryptStrBytes, "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * TEST
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "lys0111";
		String encrypt = getEncryptStr(str);
		System.out.println(encrypt);
		System.out.println("---------------------------------");
		System.out.println(getDecryptStr(encrypt));
	}
}
