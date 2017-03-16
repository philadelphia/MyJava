package com.zt.polymorphism;


/**
 * JAVA引用变量有两种类型。编译时类型与运行时类型，编译时类型是由声明该变量时指定的，运行时类型是实际赋值给该变量的类型。如果编译时类型和运行
 * 时类型不一致就会出现所谓的多态(polymorphism)
 * 
 * @author Tao.ZT.Zhang
 *
 */
public class Test {

	public static void main(String[] args) {
		
//		编译时类型与运行时类型一致，所以不会出错
//		BaseClass 编译时类型，BaseClass也是运行时类型
		BaseClass baseClass  = new BaseClass();
		System.out.println(baseClass.mark);
		baseClass.base();
		baseClass.test();
		
//		编译时类型与运行时类型一致，所以不会出错
		System.out.println("*******************");
		SubClass subClass = new SubClass();
		System.out.println(subClass.mark);
		subClass.base();
		subClass.test();
		subClass.sub();
		
//		编译时类型与运行时类型不一致
//		BaseClass 编译时类型，SubClass也是运行时类型
		System.out.println("*******************");
		BaseClass polyClass = new SubClass();
		System.out.println(polyClass.mark);  //依然显示父类的字段值，以为实例变量不具有多态性。
		polyClass.base();
		polyClass.test();
		
//		polyClass 没有sub()方法，所以无法通过编译、因为编译类型是BaseClass，而BaseClass没有sub()方法。
		((SubClass) polyClass).sub();
		
	}

}
