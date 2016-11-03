package com.zt.proxy.dynamicProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException  {
		GamePlayer realPlayer = new GamePlayer("xxxx");
		ISudent st = new GamePlayer("dddd");
		System.out.println(realPlayer.getClass().getInterfaces().length);
		IgamePlayer testPlayer = (IgamePlayer) Proxy.newProxyInstance(realPlayer.getClass().getClassLoader(), 
				realPlayer.getClass().getInterfaces(), new MyHandler(realPlayer));

		ISudent testPlayer2 = (ISudent) Proxy.newProxyInstance(realPlayer.getClass().getClassLoader(), 
				realPlayer.getClass().getInterfaces(), new MyHandler(st));
		
//		testPlayer.killBoss();
		System.out.println(testPlayer.getClass());
		System.out.println(testPlayer2.getClass());
		System.out.println(Proxy.isProxyClass(testPlayer.getClass()));

		System.out.println(Proxy.isProxyClass(realPlayer.getClass()));
		System.out.println(Proxy.getInvocationHandler(testPlayer).getClass().getName());
		System.out.println(realPlayer.getClass().getConstructors().length);
		try {
			System.out.println(realPlayer.getClass().getConstructor(String.class));
			System.out.println(realPlayer.getClass().getConstructor(String.class).newInstance("dff").toString());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {	e.printStackTrace();
		} catch (IllegalAccessException e) {	e.printStackTrace();
		} catch (IllegalArgumentException e) {	e.printStackTrace();
		} catch (InvocationTargetException e) {e.printStackTrace();
		}

		
		
		Method method = realPlayer.getClass().getMethod("killBoss", null);
				System.out.println(method.getDeclaringClass().toString());
	}

}
