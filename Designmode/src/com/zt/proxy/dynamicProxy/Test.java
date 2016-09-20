package com.zt.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		GamePlayer realPlayer = new GamePlayer("xxxx");
		System.out.println(realPlayer.getClass().getInterfaces().length);
		IgamePlayer testPlayer = (IgamePlayer) Proxy.newProxyInstance(realPlayer.getClass().getClassLoader(), 
				realPlayer.getClass().getInterfaces(), new MyHandler(realPlayer));

		
		testPlayer.killBoss();
	}

}
