package com.zt.junitdemo;

import static org.junit.Assert.*;

import javax.naming.AuthenticationException;

import org.junit.Test;

public class ClaculatorTest {

	@Test
	public void testAdd(){
		assertEquals(5, new Claculator().add(3, 3));
	}

	

	@Test(expected=ArithmeticException.class)
	public void testDivide(){
		assertEquals(3, new Claculator().divide(9, 0));
	}

	
	
}
