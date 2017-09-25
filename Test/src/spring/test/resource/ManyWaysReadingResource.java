package spring.test.resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

/**
 * @author 作者 louys:
 * @version 创建时间：2017年9月25日 上午9:42:26 类说明: spring读取资源的多种方式
 */
public class ManyWaysReadingResource {
	public static void main(String[] args) {
		try {
			String filePath = "E:/GIT/Test/Test/resources/test/readme.txt";
			// 1.使用系统文件路径加载文件
			WritableResource res1 = new PathResource(filePath);

			// 2.使用类路径加载文件
			Resource res2 = new ClassPathResource("test/readme.txt");

			// 3.使用WritableResource写文件
			OutputStream o1 = res1.getOutputStream();
			o1.write("启木日记欢迎你！".getBytes());
			o1.close();
			
			// 4.使用resource接口读取文件
			InputStream i1 = res1.getInputStream();
			InputStream i2 = res2.getInputStream();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int i;
			while((i=i2.read())!=-1){
				baos.write(i);
			}
			System.out.println(baos.toString());
			System.out.println("res1:"+res1.getFilename());
			System.out.println("res2:"+res2.getFilename());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
