package cn.lys.aop.example.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import cn.lys.aop.example.PerformanceMonitor;

/**
* @author 作者 louys:
* @version 创建时间：2017年11月10日 下午5:35:26
* 类说明
*/
public class PerformanceHandler implements InvocationHandler {
	private Object target;
	
	public PerformanceHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		PerformanceMonitor.begin(target.getClass().getName()+"."+method.getName());
		Object obj = method.invoke(target, args);
		PerformanceMonitor.end();
		return obj;
	}
}
