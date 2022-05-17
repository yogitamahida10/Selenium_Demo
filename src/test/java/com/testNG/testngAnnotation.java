package com.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testngAnnotation {
  
@Test(invocationCount=2, dependsOnMethods= {"testcase2"})
  public void Testcase1() {
	  
	  System.out.println("inside tsest case1");
  }
  
  @Test(priority=-5)
  public void testcase2() {
	  
	  System.out.println("inside tsest case 2");
	  Assert.assertEquals(true, false);
	  
  }
  
  @Test(enabled=false)
 public void testcase3() {
	  
	  System.out.println("inside tsest case 3");
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println(  "inside beforeMethod ");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println(  "inside afterMethod ");
	  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println(  "inside beforeClass ");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println(  "inside afterClass ");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println(  "inside beforeTest ");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println(  "inside afterTest ");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println(  "inside beforeSuite ");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println(  "inside afterSuite ");
  }

}
