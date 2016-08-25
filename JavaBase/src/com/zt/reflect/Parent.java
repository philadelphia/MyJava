package com.zt.reflect;

import java.util.Map;

/**
 * 
 * @author Tao.ZT.Zhang
 *
 */
public class Parent {

	private int age;
	private String name;
	private Map<String, Integer> scores;
	
	public Parent(){}
	
	private Parent(int age){}
	
	public Parent(int age, String name) {
		super();
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
	
	public void sing(){
		System.out.println("parent sings well");
	}
	
	public void sing(String music){
		System.out.println("parent sings " + music +  " well");
	}

	private void setSecret(){
		
	}
	@Override
	public String toString() {
		return "Parent [age=" + age + ", name=" + name + "]";
	}

	
	
}
