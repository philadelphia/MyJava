package com.zt.obverser;

public class Client {

	public static void main(String[] args) {
		Student student = new Student(55,"xiaowang");
		Teacher teacher = new Teacher(student);
//		Teacher teacher = new Teacher();
//		student.addObserver(teacher);
		System.out.println("No == " +student.countObservers());
		
		student.setScores(1243);
		
	}

}
