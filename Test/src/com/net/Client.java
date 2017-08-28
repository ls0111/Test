package com.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		try {
			Socket client = new Socket("localhost", 8189);
			//发送数据给服务器
			client.getOutputStream().write("I love linux!".getBytes());
			//从服务器接收数据
			InputStream in = client.getInputStream();
			byte[] bytes = new byte[1024];
			in.read(bytes);
			System.out.println("client="+new String(bytes));
			in.close();
			client.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
