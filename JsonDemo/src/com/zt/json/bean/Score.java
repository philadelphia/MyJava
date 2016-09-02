package com.zt.json.bean;

public class Score {

	private int classID;
	private float scores;
	private int rank;
	public Score(int classID, float scores, int rank) {
		super();
		this.classID = classID;
		this.scores = scores;
		this.rank = rank;
	}
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public float getScores() {
		return scores;
	}
	public void setScores(float scores) {
		this.scores = scores;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "Score [classID=" + classID + ", scores=" + scores + ", rank=" + rank + "]";
	}
	
	
	
	
	
}
