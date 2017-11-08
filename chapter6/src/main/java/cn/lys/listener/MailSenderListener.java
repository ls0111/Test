package cn.lys.listener;

import org.springframework.context.ApplicationListener;

import cn.lys.event.MailSenderEvent;

/**
* @author 作者 louys:
* @version 创建时间：2017年11月8日 上午9:04:29
* 类说明
*/
public class MailSenderListener implements ApplicationListener<MailSenderEvent>{

	@Override
	public void onApplicationEvent(MailSenderEvent event) {
		System.out.println("MailSenderListener:向"+event.getTo()+"发送完一封邮件");
	}

}
