package com.smart.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @author 作者 louys:
* @version 创建时间：2017年9月14日 下午1:25:18
* 类说明
*/
@RestController
@EnableAutoConfiguration
public class BbsDaemon {
	@RequestMapping("/")
	public String index(){
		return "欢迎来到启木日记论坛！";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BbsDaemon.class, args);
	}
}
