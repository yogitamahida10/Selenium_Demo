package com.testNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testNgAmazon {
  
@Test
  public void testAmazon() {
	  
	  System.out.println("Launching Amazon website");
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("http://amazon.ca");
	 driver.manage().window().maximize();
	 String title=driver.getTitle(); 
	 System.out.println("title:" +title );
	 Assert.assertEquals(title, "Amazon.ca: Low Prices � Fast Shipping � Millions of Items");
	 

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
