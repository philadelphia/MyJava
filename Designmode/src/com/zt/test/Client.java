package com.zt.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.json.JSONException;

import com.zt.Account;

public class Client {

	/**
	 * @param args
	 * @throws JSONException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public static void main(String[] args) throws JSONException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		// TODO Auto-generated method stub
//		Mythread thread1 = new Mythread();
//		Mythread thread2 = new Mythread();
//		Mythread thread3 = new Mythread();
//		Mythread thread4 = new Mythread();
//		Mythread thread5 = new Mythread();
//		new Thread(thread1).start();
//		new Thread(thread2).start();
//		new Thread(thread3).start();
//		new Thread(thread4).start();
//		new Thread(thread5).start();
//		
//		BMW bmw = (BMW) FactoryMode.getCar("bmw");
//		Benz bz = (Benz) FactoryMode.getCar("bz");
//		System.out.println(Benz.class.getName());
//		Jeep jee = (Jeep) FactoryMode.getCarByName("com.zt.factory.Jeep");
//		Honda honda = (Honda) FactoryMode.getCarBykey("honda");
//		bmw.show();
//		bz.show();
//		jee.show();
//		honda.show();
		
//		String dateString = "1988-11-23 13:23:34";
//		Date date = null;
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		try {
//			date = sdf.parse(dateString);
//			System.out.println("date: " + date);
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Long date1 = date.getTime();
//		int year = date.getYear();
//		int hour = date.getHours();
//		int min = date.getMinutes();
//		System.out.println("date1: " + date1);
//		System.out.println("year: " + String.valueOf(1900+year) );
//		System.out.println("hour : " + hour + " ");
//		System.out.println("min : " + min + " ");
//		Random ran = new Random();
//		int i = ran.nextInt(100);
//		System.out.println(i);
//		new Mythread().run();
//		Mythread thread1 = new Mythread();
//		Mythread thread2 = new Mythread();
////		thread1.setName("First Thread");
////		thread1.setName("First Thread");
////		thread1.setName("First Thread");
////		thread2.setName("Second Thread");
//		Thread t1 = new Thread(thread1,"t1");
//		Thread t2 = new Thread(thread2,"t2");
//		t1.setPriority(Thread.NORM_PRIORITY);
//		t2.setPriority(Thread.MAX_PRIORITY);
//		
////		for (int i = 0; i < 10; i++) {
////		System.out.println(Thread.currentThread().getName() + "thread is running---------" + i);	
////		if(i==5){
////				
////			
////				Thread.yield();
////				t1.start();
////				try {
////					t1.join();
////				} catch (InterruptedException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////				
////				t2.start();
//////				t2.join();
////		
////		}
//		}
		
		Account ac1 = new Account(1, 0);
		Mythread thread1 = new Mythread(ac1, 600);
		Mythread2 thread2 = new Mythread2(ac1, 600);
//		thread1.start();
//		thread2.start();
		
//		Map<Integer, Double> map = new HashMap<Integer, Double>();
//		map.put(1, 11.00);
//		map.put(2, 11.00);
		
//		JSONObject jsonobject = new JSONObject(map);
//		System.out.println(jsonobject);
//		String json = jsonobject.toString();
//		JSONObject json2 = new JSONObject(json);
//		int acountid = json2.getInt("acountid");
//		double blance = json2.getDouble("blance");
//		System.out.println("acountid: " + acountid);
//		System.out.println("blance: " + blance);
		
//		System.out.println(Account.class);
//		System.out.println(new Account().getClass());
//		System.out.println(Class.forName("com.zt.Account"));
		Account account = Account.getInstance();
//		System.out.println(Account.getInstance());
		 Class<? extends Account> class1 = Account.getInstance().getClass();
		 Field[] fields = class1.getDeclaredFields();
		 for (Field field : fields) {
			System.out.println(field);
		}
		 
		 System.out.println("******* Methods ********");
		 Method[] declaredMethods = class1.getDeclaredMethods();
		 for (Method method : declaredMethods) {
			System.out.println(method);
		}
		 
		 Type genericSuperclass = class1.getGenericSuperclass();
		 System.out.println(class1.getPackage());		
		System.out.println(genericSuperclass);
	}
	
	
	
//	private static class Mythread implements Runnable{
//		private SingletonHunger s ;                                                                                                       
//		
//		public void run(){
//			for (int i = 0; i < 10; i++) {
//				System.out.println( Thread.currentThread().getName() + " is running -------" + i );
//			}
//		}
//		
//	}
	
	
//	private static class Mythread extends Thread{
//		private SingletonHunger s ;
//		@Override
//		public void run(){
//			for (int i = 0; i < 10; i++) {
//				System.out.println(this.getName()+"is running -------" + i );
//			}
//		}
//		
//	}
	
	
	
	private static class Mythread extends Thread{
		public Mythread(Account account, double drawcount) {
		super();
		this.account = account;
		this.drawcount = drawcount;
	}


		private Account account ;  
		private double drawcount;
		
		
//		public void run(){
//			synchronized (account) {
//				if(account.getBlance() > drawcount){
//					System.out.println(this.currentThread().getName() + "取钱成功，取出了 " + drawcount );
//
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					account.setBlance(account.getBlance() - drawcount);
//					System.out.println("余额为：" + account.getBlance());
//				}else {
//					System.out.println(this.currentThread().getName()+"余额不足，取钱失败!"+"余额为： "+ account.getBlance());
//				}
//				
//			}
//			
//			}
		public void run(){
			for (int i = 0; i < 10; i++) {
				account.draw(drawcount);
				}
			}
			
	}
	
	private static class Mythread2 extends Thread{
		public Mythread2(Account account, double depositcount) {
			super();
			this.account = account;
			this.depositcount = depositcount;
		}

		private Account account ;  
		private double depositcount;
		
		public void run(){
			for (int i = 0; i < 10; i++) {
				account.deposit(depositcount);
			}
			
		}
	}

}
