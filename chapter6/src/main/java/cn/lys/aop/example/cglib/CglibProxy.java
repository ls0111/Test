package cn.lys.aop.example.cglib;

import java.lang.reflect.Method;

import cn.lys.aop.example.PerformanceMonitor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
* @author 作者 louys:
* @version 创建时间：2017年11月10日 下午6:14:06
* 类说明
*/
public class CglibProxy implements MethodInterceptor{
	private Enhancer enhancer = new Enhancer();
	
	@SuppressWarnings("rawtypes")
	public Object getProxy(Class clazz){
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object target, Method method, Object[] param, MethodProxy proxy) throws Throwable {
		PerformanceMonitor.begin(target.getClass().getName()+"."+method.getName());
		Object obj = proxy.invokeSuper(target, param);
		PerformanceMonitor.end();
		return obj;
	}

}
