package com.zt.reflect;

@Anno
public class Son extends Parent {
	private int age;
	private String name;
	
	
	 public Son(){
		 super();
	 }
	
	public Son(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void draw(){
		System.out.println("son draws well");
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
