package com.zt.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

public class Test {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchFieldException {

//		testMethod(getClass(new Parent()));
//		printClassInfo(getClass(new Parent()));
		
		
//		Class<Parent> clazz = Parent.class;
//		Parent parent = new Parent();
//		Field ageField = clazz.getDeclaredField("age");
//		ageField.setAccessible(true);
//		ageField.set(parent, 30);
//		System.out.println(parent.toString());
//		
//		Field nameField = clazz.getDeclaredField("name");
//		nameField.setAccessible(true);
//		nameField.set(parent, "dd");
//		
//		System.out.println(parent);
		
		Parent parent = new Parent();
		Field field = parent.getClass().getDeclaredField("scores");
		field.setAccessible(true);
		System.out.println(field.getName());
		System.out.println(field.getType());
		Class<?> type = field.getType();
		Type genericType = field.getGenericType();
		System.out.println(genericType.getTypeName());
		
		if (genericType instanceof ParameterizedType) {
			Type rawType = ((ParameterizedType) genericType).getRawType();
			System.out.println("原始類型是== " + rawType);
			Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
			for (Type type2 : actualTypeArguments) {
				System.out.println("實際類型是:== " + type2   );
			}
		}
	}

	public static Class<? extends Object> getClass(Object object) throws ClassNotFoundException {
		/**
		 * get an class object 3 ways
		 */
		// first way
		Class<?> clazz1 = Parent.class;
		System.out.println(clazz1.toString());

		// second way
		Class<?> clazz2 = object.getClass();
		System.out.println(clazz2.toString());

		// third way
		Class<?> clazz3 = Class.forName("com.zt.reflect.Parent");
		System.out.println(clazz3.toString());
		
		return clazz2;

	}

	/**
	 * create a new object from class object
	 */
	public static <T> T getAnInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//调用无参的构造方法,使用類對象的newInstance默認只會調用無參構造方法。
//		return clazz.newInstance();

		//调用有参的构造方法
		Constructor<T> constructor = clazz.getDeclaredConstructor(int.class, String.class);
		return constructor.newInstance(34, "xaiozhang");
		
		
	}

	public static void testMethod(Class<?> clazz) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = clazz.getMethod("sing");
		method.invoke(new Parent());
		Method methodSetAge = clazz.getMethod("setAge", int.class);
		System.out.println(methodSetAge.getName());
		Parent parent = new Parent(23, "zt");
		methodSetAge.invoke(parent, 24);
		System.out.println(parent.toString());

	}

	public static void printClassInfo(Class<?> clazz) throws IllegalArgumentException, IllegalAccessException {

		/**
		 * 获取Parent的所有Field
		 * 
		 */
		System.out.println("-------------------Field-----------------------");
		Field[] declaredFields = clazz.getDeclaredFields();
		System.out.println("modifier" + "\t" + "type" + "\t" + "name");
		for (Field field : declaredFields) {
			field.setAccessible(true);
			printFieldInfo(field);
		}

		/**
		 * 获取Parent的所有构造方法
		 * 
		 */
		System.out.println("-------------------Constructor-----------------------");
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor2 : constructors) {
			System.out.println(constructor2.getModifiers() + "\t" + constructor2.getName() + "\t"
					+ constructor2.getParameterCount());
		}

		/**
		 * 获取Parent的所有方法
		 * 
		 */
		System.out.println("-------------------Methods-----------------------");
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method.getModifiers() + "\t" + method.getName() + "\t" + method.getParameterCount());
		}

		System.out.println("package name = " + clazz.getPackage());
		System.out.println("SuperClass == " + clazz.getSuperclass().getName());
		System.out.println("Name == " + clazz.getName());
		System.out.println("simpleName == " + clazz.getSimpleName());
		System.out.println("isAnnotation == " + clazz.isAnnotation());
		System.out.println("isEnum == " + clazz.isEnum());
		System.out.println("isInstance == " + clazz.isInstance(new Parent()));
		System.out.println("isInterface == " + clazz.isInterface());
		System.out.println(Modifier.isPublic(clazz.getModifiers()));
	}
	
	public static void printFieldInfo(Field field){
		
		System.out.println(field.getModifiers() + "\t\t" + field.getType() + "\t" + 
	field.getName());
	}
	
}
