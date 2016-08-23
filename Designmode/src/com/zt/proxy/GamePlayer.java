package com.zt.proxy;

public class GamePlayer implements IgamePlayer {

	private String name;
	
	
	public GamePlayer(String name) {
		super();
		this.name = name;
	}

	@Override
	public void login(String userName, String password) {
		System.out.println(this.name + " loging.....");
		
	}

	@Override
	public void killBoss() {
		System.out.println(this.name + " is killing boss.....");
		
	}

	@Override
	public void upgrade() {
		System.out.println(this.name + " upgrade.....");
		
	}

}
