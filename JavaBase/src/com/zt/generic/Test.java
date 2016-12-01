package com.zt.generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*PECS原则

	如果要从集合中读取类型T的数据，并且不能写入，可以使用 ? extends 通配符；(Producer Extends)
	如果要从集合中写入类型T的数据，并且不需要读取，可以使用 ? super 通配符；(Consumer Super)
	如果既要存又要取，那么就不要使用任何通配符。
*/	
public class Test {
	static Map<String,Integer> map = new HashMap<>();
	static String name ;

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		
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
		
		
		System.out.println("-----------------");
		
		printGenericInfo();
	
	}
	
//	该方法的参数可以为ArrayList<T>,但是如果参数为ArrayList<?>类型。传人一个List<? extends T>类型的集合就会报错。即使泛型参数是T的子类也不行。
	public static void  printList(List<?> list){
		for (Object object : list) {
			System.out.println(object.toString());
		}
		
	}
	
	
	public static void printGenericInfo() throws NoSuchFieldException, SecurityException{
		Map<String,String> map = new HashMap<>();
		Class<Test> clazz = Test.class;
		Field field = clazz.getDeclaredField("map");
		Field name = clazz.getDeclaredField("name");
		System.out.println("name的类型是:" + name.getType());
		System.out.println("field的类型是:" + field.getType());
		
		Type type1 = field.getGenericType();
		Type type2 = name.getGenericType();
		System.out.println("field的泛型类型是: " + type1);
		System.out.println("name的泛型类型是: " + type2);
		
		if (type1 instanceof ParameterizedType) {
			System.out.println("--------------");
				ParameterizedType parameterizedType  = (ParameterizedType)type1;
				System.out.println(parameterizedType.getRawType());
				Type[] types = parameterizedType.getActualTypeArguments();
				for (Type type : types) {
					System.out.println(type);
				}
		}
	}
	

}
