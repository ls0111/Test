package cn.lys.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import cn.lys.event.MailSenderEvent;

/**
* @author 作者 louys:
* @version 创建时间：2017年11月8日 上午9:07:48
* 类说明
*/
public class MailSender implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public void sendMail(String to){
		System.out.println("模拟发送邮件");
		MailSenderEvent me = new MailSenderEvent(applicationContext, to);
		this.applicationContext.publishEvent(me);
	}
}
