package com.zt.demo;

public class Student implements Cloneable{

	private int age;
	private String name;
	private Score socre;
	
	
	public Student() {
		super();
	}


	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	public Student(int age, String name, Score score) {
		super();
		this.age = age;
		this.name = name;
		this.socre = score;
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


	
	
	public Score getSocre() {
		return socre;
	}


	public void setSocre(Score socre) {
		this.socre = socre;
	}


	
	@Override
	public Student clone() {
		try {
			Student clone = (Student) super.clone();
			clone.age = this.getAge();
			clone.name = this.getName();
			clone.socre = this.getSocre().clone();
			return clone;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}


	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + ", socre=" + socre + "]";
	}
	
	
	
}
