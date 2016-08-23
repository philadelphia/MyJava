package com.zt.proxy;

public class Test {

	public static void main(String[] args) {
		IgamePlayer gamePlayer = new GamePlayer("张三");
		IgamePlayer proxy = new GamePlayerProxy(gamePlayer);
		
		proxy.login("zhangsan", "password");
		proxy.killBoss();
		proxy.upgrade();
	}
}
