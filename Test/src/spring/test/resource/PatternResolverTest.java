package spring.test.resource;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.DefaultResourceLoader;

public class PatternResolverTest {
	public static void main(String[] args) throws IOException {
		File file = (new DefaultResourceLoader()).getResource("classpath*:com/**/*.xml").getFile();
		System.out.println(file.getName());
	}
}
