package com.zt.generic;

import java.util.ArrayList;
import java.util.List;

/*PECS原则

	如果要从集合中读取类型T的数据，并且不能写入，可以使用 ? extends 通配符；(Producer Extends)
	如果要从集合中写入类型T的数据，并且不需要读取，可以使用 ? super 通配符；(Consumer Super)
	如果既要存又要取，那么就不要使用任何通配符。
*/	
public class Test {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		List<People> list = new ArrayList<>();
		list.add(new People());
		list.add(new Student(34));
		printList(list);
		
//		使用extends后，list不能添加people和其子类的对象。因为在编译的时候不能确定其具体类型。
		List<? extends  People> list2 = new ArrayList<>();
//		list2.add(new Student(45));
//		list2.add(new People());
		
		
//		使用super后无法向集合中添加people的父类的对象。因为不能确定其具体类型。但是可以添加people和其子类的对象。
		List<? super People> list3 = new ArrayList<>();
		list3.add(new People());
		list3.add(new Student(67));
//		list3.add(new Object());
		printList(list3);
		
		
	
	}
	
//	该方法的参数可以为ArrayList<T>,但是如果参数为ArrayList<?>类型。传人一个List<? extends T>类型的集合就会报错。即使泛型参数是T的子类也不行。
	public static void  printList(List<?> list){
		for (Object object : list) {
			System.out.println(object.toString());
		}
		
	}

}
