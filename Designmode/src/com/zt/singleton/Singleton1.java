package com.zt.singleton;

/**
 * 懒汉式
 * 在类装载时就进行了实例化
 * 优点：没有加锁，线程安全，执行效率高
 * 缺点：类加载时就初始化，浪费资源
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
