package cn.lys.aop.example;
/**
* @author 作者 louys:
* @version 创建时间：2017年11月10日 下午5:23:51
* 类说明
*/
public class PerformanceMonitor {
	private static ThreadLocal<MethodPerformance> perfomanceRecord = new ThreadLocal<MethodPerformance>();
	
	public static void begin(String method){
		System.out.println("begin monitor ...");
		MethodPerformance mp = new MethodPerformance(method);
		perfomanceRecord.set(mp);
	}
	
	public static void end(){
		System.out.println("end monitor ...");
		MethodPerformance mp = perfomanceRecord.get();
		mp.printPerformance();
	}
}
