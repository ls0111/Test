package cn.lys.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
* @author 作者 louys:
* @version 创建时间：2017年11月8日 上午9:00:32
* 类说明
*/
public class MailSenderEvent extends ApplicationContextEvent {
	private static final long serialVersionUID = -4223848448533750323L;
	
	private String to;
	public MailSenderEvent(ApplicationContext source, String to) {
		super(source);
		this.to = to;
	}
	
	public String getTo(){
		return this.to;
	}
}
