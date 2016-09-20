package com.zt.proxy.staticProxy;

public class GamePlayerProxy implements IgamePlayer {

	private IgamePlayer gamePlayer;
	
	public  GamePlayerProxy(IgamePlayer player) {
		this.gamePlayer = player;
	}
	@Override
	public void login(String userName, String password) {
		
		this.gamePlayer.login(userName, password);
		
	}

	@Override
	public void killBoss() {
		this.gamePlayer.killBoss();
		
	}

	@Override
	public void upgrade() {
		this.gamePlayer.upgrade();
		
	}

}
