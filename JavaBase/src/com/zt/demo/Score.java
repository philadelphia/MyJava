package com.zt.demo;

public class Score implements Cloneable{

	private int id;
	private float scores;
	
	
	
	public Score(int id, float scores) {
		super();
		this.id = id;
		this.scores = scores;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getScores() {
		return scores;
	}
	public void setScores(float scores) {
		this.scores = scores;
	}
	
	public Score clone(){
		try {
			return (Score) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", scores=" + scores + "]";
	}
	
	
	
	
}
