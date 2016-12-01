package com.zt.polymorphism;

public class SubClass extends BaseClass{
	public String mark = "SubClass";

	
	public void test() {
		super.test();
		System.out.println("test--子类复写父类的方法");
	}
	
	
	public void sub(){
		System.out.println("子类自定义的方法");
	}

	

}
