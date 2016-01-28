package com.zt.singleton;

public class SingletonHunger {
	
	private static SingletonHunger instance ;
	private final static Object object = new Object();
	private SingletonHunger(){}
	
	public static synchronized SingletonHunger getInstance(){
//		synchronized (object) {
//		
//		}
		if(null == instance ){
			instance = new SingletonHunger();
			return instance;
		}else {
			return instance;
		}
	
	}

}
