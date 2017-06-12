package com.zt.singleton;

/**
 * 懒汉式
 * 添加synchronized可以在多线程情况下保证单例对象的唯一性
 * 优点：单例只有在使用的时候才会进行实例化，在一定程度上节约了资源。
 * 缺点：第一次加载需要实例化，反应稍慢，每次调用时都同步，造成不必要的开销。
 */
public class Singleton1 {
	
	private static Singleton1 instance;
	
	private Singleton1(){}
	
	public static synchronized Singleton1 getInstance(){
		if(instance == null){
			instance = new Singleton1();
		}

		return instance;
	}

}
