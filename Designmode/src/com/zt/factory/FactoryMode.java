package com.zt.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FactoryMode {
	private static Icar car  ;
	
	public static Icar getCar(String carMode){
		if("bz".equals(carMode)){
			car = new Benz();
		}else if ("bmw".equals(carMode)) {
			car = new BMW();
		}
		return car;
	}
	
	public static Icar getCarByName(String className){
		try {
			car = (Icar) Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car;
	}

	
	public static Icar getCarBykey(String keyName){
		Properties pp = new Properties();
		try {
			pp.load(new FileInputStream("Project.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Set<Object> set = pp.keySet();
//		for (Object object : set) {
//			String name = pp.getProperty((String) object);
//			System.out.println(object.toString());
//			System.out.println(name);
//		}
		String name = pp.getProperty((String) keyName);
		try {
			car = (Icar) Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car;
	}
}
