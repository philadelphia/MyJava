package com.zt.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

	private Object object;
	
	public  MyHandler(Object object) {
		this.object = object;
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("before kill boss");
		method.invoke(object, args);
		System.out.println("after kill boss");
		return null;
	}

}
