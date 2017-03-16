package com.zt.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
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
		Parent parent = new Parent(34, "xxx");
		Son son = new Son(23,"dfg");
		SubChild child = new SubChild();
//		printAllDeclaredConstructorFunctions(son.getClass());
//		printAllDeclaredConstructorFunctions(parent.getClass());
//			
//		printAllConstructorFunctions(son.getClass());
//		printAllConstructorFunctions(parent.getClass());
//		printAllDeclaredConstructorFunctions(child.getClass());
//		printAllConstructorFunctions(child.getClass());
		
		printClassInfo(son.getClass());
		
	}

	
	public static Class<? extends Object> getClassObject(Object object) throws ClassNotFoundException {
		
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

	public static void printMethods(Class<?> clazz) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] methods  = clazz.getDeclaredMethods();
		for (Method method : methods) {
			printMethodInformation(method);
		}
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

		

		System.out.println("package name = " + clazz.getPackage());
		System.out.println("SuperClass == " + clazz.getSuperclass().getName());
		System.out.println("Name == " + clazz.getName());
		System.out.println("simpleName == " + clazz.getSimpleName());
		System.out.println("isAnnotation == " + clazz.isAnnotation());
		System.out.println("isEnum == " + clazz.isEnum());
		System.out.println("isInstance == " + clazz.isInstance(new Parent()));
		System.out.println("isInterface == " + clazz.isInterface());
		System.out.println(Modifier.isPublic(clazz.getModifiers()));
		
		Annotation[] annotations = clazz.getDeclaredAnnotations();
		System.out.println(annotations.length);
		for (Annotation annotation : annotations) {
			System.out.println(annotation.getClass());
		}
	}
	
	public static void printFieldInfo(Field field){
		
		System.out.println(field.getModifiers() + "\t\t" + field.getType() + "\t" + 
		field.getName());
	}
	
	
	/**
	 * 获取所有构造方法
	 * 
	 */
	public static void printAllDeclaredConstructorFunctions(Class<?> clazz){
		System.out.println("-------------------Constructor-----------------------");
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor2 : constructors) {
			System.out.println(Modifier.toString(constructor2.getModifiers())  + " " + constructor2.getName() + "\t"
					+ constructor2.getParameterCount());
		}
	
	}
	
	
	public static void printAllConstructor(Class<?> clazz){
		Constructor[] constructors = clazz.getConstructors();
		for (Constructor<?> constructor2 : constructors) {
			System.out.println(Modifier.toString(constructor2.getModifiers())  + " " + constructor2.getName() + "\t"
					+ constructor2.getParameterCount());
		}
	}

	/**
	 * 获取所有构造方法,包含继承的构造方法
	 * 
	 */
	public static void printAllConstructorFunctions(Class<?> clazz){
	
		Class superClazz = clazz.getSuperclass();
		if (superClazz instanceof Class) {
			printAllConstructorFunctions(superClazz);
		}
		System.out.println("-------------------Constructor-----------------------");
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor2 : constructors) {
			System.out.println(Modifier.toString(constructor2.getModifiers())  + " " + constructor2.getName() + "\t"
					+ constructor2.getParameterCount());
		}
	
		
	}
	
	
	private static void testGenericInfo(Field field) {
		field.setAccessible(true);
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
	
	public static void printAllFunctions(Class<?> clazz){
		/**
		 * 获取Parent的所有方法
		 * 
		 */
		System.out.println("-------------------Methods-----------------------");
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method.getModifiers() + "\t" + method.getName() + "\t" + method.getParameterCount());
		}
	}
	
	public static void printMethodInformation(Method method){
		System.out.print(Modifier.toString(method.getModifiers()) + " " + method.getName() + "(" );
		Class[] types =  method.getParameterTypes();
		for (Class class1 : types) {
			System.out.print(class1.getName());
		}
		System.out.println(")");
		 
		Annotation[]  annotations = method.getAnnotations();
		for (Annotation annotation : annotations) {
			printAnnotatationInfo(annotation);
		}
		
	}
	
	public static void printAnnotatationInfo(Annotation anno){
		System.out.println(anno.getClass());
	}
}
