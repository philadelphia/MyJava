package com.zt.json.bean;

import java.util.List;

public class Student {
	private int age;
	private String name;
	private List<Score> scores;
	
	
	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
		
	}
	
	
	public Student(int age, String name, List<Score> scores) {
		super();
		this.age = age;
		this.name = name;
		this.scores = scores;
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
	public List<Score> getScores() {
		return scores;
	}
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}


	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + ", scores=" + scores + "]";
	}
	
	

}
