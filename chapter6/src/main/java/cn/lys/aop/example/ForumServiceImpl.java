package cn.lys.aop.example;

/**
* @author 作者 louys:
* @version 创建时间：2017年11月10日 下午3:21:05
* 类说明
*/

public class ForumServiceImpl implements IForumService {
	
	@Override
	public void addTopic(int id){
		System.out.println("add Topic:" + id);
	}
	
	@Override
	public void removeTopic(int id){
		System.out.println("remove Topic:" + id);
	}
}
