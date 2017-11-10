package cn.lys.aop.example;

import java.lang.reflect.Proxy;

import cn.lys.aop.example.handler.PerformanceHandler;

/**
 * @author 作者 louys:
 * @version 创建时间：2017年11月10日 下午5:28:38 类说明
 */
public class TestForumService {
	public static void main(String[] args) {
		IForumService target = new ForumServiceImpl();
		PerformanceHandler handler = new PerformanceHandler(target);
		IForumService proxy = (IForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), handler);
		
		proxy.addTopic(123);
		proxy.removeTopic(12);
	}
}
