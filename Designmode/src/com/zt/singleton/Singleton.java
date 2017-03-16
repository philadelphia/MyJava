package com.zt.singleton;

/**
 * 恶汉式
 * 在类装载时就进行了实例化
 * 优点：没有加锁，线程安全，执行效率高
 * 缺点：类加载时就初始化，浪费资源
 */
public class Singleton {
	
	private static Singleton instance = new Singleton();
	
	private Singleton(){}
	
	public static Singleton getInstance(){

		return instance;
	}

}
