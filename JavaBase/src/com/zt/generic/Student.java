package com.zt.generic;

public class Student extends People{

	private float scores;
	
	

	public Student(float scores) {
		super();
		this.scores = scores;
	}

	public float getScores() {
		return scores;
	}

	public void setScores(float scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "Student [scores=" + scores + "]";
	}
	
	
}
