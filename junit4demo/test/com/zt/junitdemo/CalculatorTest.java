package com.zt.junitdemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	
	
	@Test
	public void testAdd(){
		assertEquals(6, new Claculator().add(3, 3));
	}
	
	@Test
	public void testMinus(){
		assertEquals(6, new Claculator().minus(9, 3));
	}
	
	@Test
	public void testMultiply(){
		assertEquals(27, new Claculator().multiply(9, 3));
	}
	
	@Test
	public void testDivide(){
		assertEquals(3, new Claculator().divide(9, 3));
		System.out.println("this is testing divide function");
	}
}
