package com.zt.proxy.dynamicProxy;

public class GamePlayer implements IgamePlayer,ISudent {

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

	@Override
	public void study() {
		System.out.println("studying.........");
		
	}

	@Override
	public String toString() {
		return "GamePlayer [name=" + name + "]";
	}
	
	
}
