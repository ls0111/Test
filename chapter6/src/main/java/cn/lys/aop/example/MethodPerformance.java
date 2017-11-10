package cn.lys.aop.example;
/**
* @author 作者 louys:
* @version 创建时间：2017年11月10日 下午5:24:34
* 类说明
*/
public class MethodPerformance {
	private long begin;
	private long end;
	private String serviceMethod;
	
	public MethodPerformance(String serviceMethod){
		this.serviceMethod = serviceMethod;
		this.begin = System.currentTimeMillis();
	}
	
	public void printPerformance(){
		end = System.currentTimeMillis();
		long elapse = end - begin;
		System.out.println(serviceMethod + "花费" + elapse + "毫秒！");
	}
}
