package cn.lys.aop.example.handler;

import cn.lys.aop.example.ForumServiceImpl;
import cn.lys.aop.example.cglib.CglibProxy;

/**
 * @author 作者 louys:
 * @version 创建时间：2017年11月10日 下午5:28:38 类说明
 */
public class TestCglibForumService {
	public static void main(String[] args) {
		CglibProxy proxiy = new CglibProxy();
		ForumServiceImpl forumService = (ForumServiceImpl) proxiy.getProxy(ForumServiceImpl.class);
		forumService.addTopic(12);
		forumService.removeTopic(12);
	}
}
