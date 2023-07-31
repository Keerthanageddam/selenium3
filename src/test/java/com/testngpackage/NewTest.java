package com.testngpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class NewTest {
  @Test
  public void f() {
	  System.out.println("print 1");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("print 2");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("print 3");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("print 4");
  }

}
