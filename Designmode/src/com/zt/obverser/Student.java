package com.zt.obverser;

import java.lang.reflect.Field;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class Student extends Observable{
	
	private float scores;
	private String name;
	
	public Student(){
		
	}
	
	public Student(float scores, String name) {
		super();
		this.scores = scores;
		this.name = name;
	}

	public float getScores() {
		return scores;
	}

	public void setScores(float scores) {
		
		System.out.println("setScores");
		this.scores = scores;
		setChanged();
		notifyObservers();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
		System.out.println("add  a observer");
	}

	@Override
	public synchronized void deleteObserver(Observer o) {
		System.out.println("remove a observer");
	}

	@Override
	public void notifyObservers() {
		System.out.println("notify observers");
		
		//自定义通知观察者列表
//		Field declaredField;
//		try {
//			Vector<Observer> ves ;
//			declaredField = this.getClass().getSuperclass().getDeclaredField("obs");
//			declaredField.setAccessible(true);
//			ves = (Vector<Observer>) declaredField.get(this);
//			System.out.println(ves.size()); 
////			System.out.println((Vector<Observer>)declaredField.get(new Student()));
////			System.out.println(declaredField.get);
//			for (int i = 0; i < ves.size(); i++) {
//				ves.get(i).update(this, null);
//				
//			}
//		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		super.notifyObservers();
	}

	

	@Override
	public void notifyObservers(Object arg) {
		
		super.notifyObservers(arg);
	}

	@Override
	public synchronized void deleteObservers() {
		System.out.println("remove all observer");
		super.deleteObservers();
	}



	

}
