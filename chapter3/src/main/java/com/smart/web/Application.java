package com.smart.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* @author 作者 louys:
* @version 创建时间：2017年9月14日 下午1:25:18
* 类说明
*/
//@RestController
@SpringBootApplication
@EnableAutoConfiguration
public class Application extends SrpingBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
