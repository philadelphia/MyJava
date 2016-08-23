package com.zt.obverser;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer{

	private float scores;
	
	public Teacher(Observable studnet){
		studnet.addObserver(this);
	}
	public Teacher(){
		
	}

	public float getScores() {
		return scores;
	}

	public void setScores(Object arg) {
		this.scores = (float) arg;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("calling");
		System.out.println("student's scores is: " + ((Student)o).getScores()  );
	}
	
	
	
}
