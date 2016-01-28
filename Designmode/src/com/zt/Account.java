package com.zt;

public class Account {
	private int acountid;
	private double blance;
	private boolean flag = false; //已經有人存過了
	
	private static Account account = new Account();
	public static Account getInstance(){
		return account;
	}
	
	
	
	
	private  Account() {
	}
	public Account(int acountid, double blance) {
		super();
		this.acountid = acountid;
		this.blance = blance;
	}
	public int getAcountid() {
		return acountid;
	}
	public void setAcountid(int acountid) {
		this.acountid = acountid;
	}
	public double getBlance() {
		return blance;
	}
	public void setBlance(double blance) {
		this.blance = blance;
	}
	
	public synchronized void draw(double drawcount){
		if(flag){
			System.out.println(Thread.currentThread().getName() + "取钱成功，取出了 " + drawcount );
			this.setBlance(this.getBlance() - drawcount);
			System.out.println("余额为：" + this.getBlance());
			flag = false;
			notify();
		}else {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}	
	
	public synchronized void deposit(double depositcount){
		if(flag){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			this.setBlance(this.getBlance() + depositcount);
			System.out.println(Thread.currentThread().getName() + "余额为：" + this.getBlance());
			flag = true;
			System.out.println(Thread.currentThread().getName() +"充值成功！");
			notify();
		}
	}
			
}
