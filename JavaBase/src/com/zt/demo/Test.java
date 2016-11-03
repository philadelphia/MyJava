package com.zt.demo;

public class Test {

	public static void main(String[] args) {
		Student s1 = new Student(12, "dd",new Score(12, 123));
		Student s2 = s1.clone();
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		
		s2.getSocre().setId(3);
		System.out.println(s1.getName().hashCode());
		System.out.println(s2.getName().hashCode());
		System.out.println(s1.toString());
		System.out.println(s2.toString());

		System.out.println(Student.class.getName());
		System.out.println(Student.class.getSimpleName());
		System.out.println(Student.class.getPackage());
		System.out.println(Student.class.getTypeParameters().toString());
	}

}
