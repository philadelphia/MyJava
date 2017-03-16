package com.zt.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 双重加锁模式Double Check Lock
 * 对懒汉式进一步的完善，不仅可以避免每次都进行同步造成不必要的开销，
 * 也可以在需要的时候在进行实例化，节省资源。
 * @author tao.zt.zhang
 *
 */
public class SingletonDCL {
	
	/*JVAV 对象的生产包含以下三个步骤:
	 * instance = new Singleton();实际上包含三步：
	 * 1：inst = alloc();//分配内存;
	 * 2：consturctor(inst);//构造函数初始化inst;
	 * 3: instance = inst; //将inst赋值给instance;
	 * 此处一定要加上volatile关键字，因为JAVA运行乱序执行
	 * 
	 * 由于Java编译器允许处理器乱序执行，所以第二步和第三步的顺序无法保证。如果第三步先执行完毕、第二步未执行时，
	 * 有另外的线程调用了instance，由于已经赋值，将判断不为null，拿去直接使用，
	 * 但其实构造函数还未执行，成员变量等字段都未初始化，直接使用，就会报错。这就是DCL失效问题，而且很难复现。
	 * 对volatile变量的写操作，不允许和它之前的读写操作打乱顺序；对volatile变量的读操作，不允许和它之后的读写乱序。
	 * 总之，加了volatile关键字，步骤2和3就不会乱序执行了。
	 */
	private static volatile SingletonDCL instance ;
	
	private SingletonDCL(){}
	
	public static synchronized SingletonDCL getInstance(){
		if(null == instance ){
			synchronized (SingletonDCL.class) {
				if(instance == null){
					instance = new SingletonDCL();
					}
				}
			}

		return instance;
	}
	
	
	//以下实现单例模式的其他方式
	
	/**
	 * 静态内部类的形式 
	 * @author tao.zt.zhang
	 *静态内部类单例线程安全，能保证唯一性，在需要的时候再进行实例化
	 */
	public static class Singleton {  
	    private Singleton() {  
	    }  
	  
	    public static Singleton getInstance() {  
	        return SingletonInstance.instance;  
	    }  
	  
	    private static class SingletonInstance {  
	        private static final Singleton instance = new Singleton();  
	    }  
	}  
	
	/**
	 * 容器实现单例模式
	 * 利用Map中value能重复的机制实现单例
	 */
	
	public static class Singleton2 {  
	    private static Map<String, Object> instanceMap = new HashMap<String, Object>();  
	  
	    private Singleton2() {  
	    }  
	  
	    public static void addInstance(String key, Object instance) {  
	        if (!instanceMap.containsKey(key)) {  
	            instanceMap.put(key, instance);  
	        }  
	    }  
	  
	    public static Object getInstance(String key) {  
	        return instanceMap.get(key);  
	    }  
	} 
}


