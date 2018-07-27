package com.zt;

public class Account {
	private int acountid;
	private double blance;
	private boolean flag = false; //�ѽ����˴��^��
	
	private static Account account = new Account();
	public static Account getInstance(){
		
//		syso("this is test");
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
			System.out.println(Thread.currentThread().getName() + "ȡǮ�ɹ���ȡ���� " + drawcount );
			this.setBlance(this.getBlance() - drawcount);
			System.out.println("���Ϊ��" + this.getBlance());
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
			System.out.println(Thread.currentThread().getName() + "���Ϊ��" + this.getBlance());
			flag = true;
			System.out.println(Thread.currentThread().getName() +"��ֵ�ɹ���");
			notify();
		}
	}
			
}
