package com.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class TestSerializable {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		People p = new People();
		p.setAge(10);
		p.setBirthday(new Date());
		p.setName("Tom");
		//序列化
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:/testserializable")));
		oos.writeObject(p);
		oos.flush();
		oos.close();
		//反序列化
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:/testserializable")));
		try {
			People sp = (People) ois.readObject();
			System.out.println(sp);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			ois.close();
		}
		
	}
}
