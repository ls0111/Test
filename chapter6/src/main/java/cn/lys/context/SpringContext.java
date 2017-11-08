package cn.lys.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.lys.bean.MailSender;

/**
* @author 作者 louys:
* @version 创建时间：2017年10月17日 下午1:11:46
* 类说明
*/
public class SpringContext {
	public static void main(String[] args) {
		String path = "classpath:smart-context.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
		MailSender ms = (MailSender) ctx.getBean("mailSender");
		ms.sendMail("aaa@bbb.com");
	}
}
