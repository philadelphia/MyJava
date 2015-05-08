package com.zt.junitdemo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@Suite.SuiteClasses({Test1.class,Test2.class,CalculatorTest.class})
public class SuiteTest {


}
