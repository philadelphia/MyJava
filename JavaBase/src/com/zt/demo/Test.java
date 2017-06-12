package com.zt.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


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
		
		List<Student> students  = new ArrayList<>();
		students.add(new Student(1, "dfg"));
		students.add(new Student(2, "222"));
		System.out.println(students);
		students.get(0).setAge(12);
//		此时集合中的数据已经被修改了。
		System.out.println(students);
//		被Collections集合类的unmodifiableCollection处理过的集合由于不提供get()方法。所以无法修改集合中的元素。
//		变相的实现了不可变集合。
//		unmodifiableCollection()该方法返回一个UnmodifiableCollection对象。
//		UnmodifiableCollection类实现了Collection接口。没有get()方法，get是List集合自己的方法，
		Collections.unmodifiableCollection(students);
		System.out.println(students);
		
		
		

//		使用Arrays.asList(arrays)方法将数组变为集合的一个注意点是：修改此结合的数据同时会修改该数组中的元素。
//		如果如要解决这个问题可以生成一个新的结合，然后使用Collections.addAll(list1, arrays);
//		此时修改集合中的数据就不会影响数组中的元素了。
	
		
		String[] arrays = new String[] {"hello", "World", "Hello", "Hadoop"};
		for (int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] + "\t");
		}
		System.out.println();
		List<String> list = (List<String>) Arrays.asList(arrays);
		list.set(0, "ttt");
		for (int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] + "\t");
		}
		System.out.println(Arrays.asList(arrays));
		List<String> list1 = new ArrayList<>();
		Collections.addAll(list1, arrays);
		list1.set(0, "test");
		for (int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] + "\t");
		}
		System.out.println();
		System.out.println(Arrays.asList(arrays));
		System.out.println(list1);

//		Student s = new Student();
//
//		System.out.println(s instanceof Student);
//		s = null;
//		System.out.println(s instanceof Student);

		
	}

}
