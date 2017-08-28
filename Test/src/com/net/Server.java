package com.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8189);
			Socket data = server.accept();
			//接收客户端数据
			InputStream in = data.getInputStream();
			byte[] bytes = new byte[1024];
			//返回数据到客户端
			data.getOutputStream().write("Has received data!".getBytes());
			in.read(bytes);
			in.close();
			data.close();
			server.close();
			System.out.println("server="+new String(bytes));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
