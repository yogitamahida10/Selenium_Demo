package com.testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer;
import com.utility.libraryfunction;
import com.utility.objectrespositery2;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class GmoOnline2 extends libraryfunction{ //Two ways for accessing common function across the project: inheritance and by using static method or variable
	

	@Test(priority = -1)
	public void LaunchGmoOnline() {
		System.out.println("inside LaunchGmoOnline");
		driver.get("http://demo.borland.com/gmopost/");
		//libraryfunction.driver.get("http://demo.borland.com/gmopost/");//   by using static variable
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("title:" + title);
		Assert.assertEquals(title, "Welcome to Green Mountain Outpost");
	}

	@Test(priority = 0, dependsOnMethods = { "LaunchGmoOnline" })
	public void EnterGmoOnlineAndOrderExternalFrameBackPack() {
		System.out.println("inside EnterGmoOnlineAndOrderExternalFrameBackPack");
		driver.findElement(By.name(objectrespositery2.Gmoonlinebuttonsubmit)).click();
		String EnterGmoOnlineText = driver.findElement(By.xpath(objectrespositery2.GmoOnlinetext)).getText();
		System.out.println("titleEnterGmoOnline:" + EnterGmoOnlineText);
		//Assert.assertEquals(EnterGmoOnlineText, "OnLine Catalo");
		
		SoftAssert objsoftAssert = new SoftAssert();
		objsoftAssert.assertEquals(EnterGmoOnlineText, "OnLine Catalog");

		driver.findElement(By.name(objectrespositery2.QtyBackPack)).sendKeys("5");
		driver.findElement(By.xpath(objectrespositery2.PlaceAnOrder)).click();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		String titlePaceOrder = driver.getTitle();
		Assert.assertEquals(titlePaceOrder, "Place Order");
		objsoftAssert.assertAll();
		
	}
	
	@Test(priority=1)
	public void ValidatePriceCalculation() {
		System.out.println("inside ValidatePriceCalculation");
		String UniPriceFromWebTable  = driver.findElement(By.xpath(objectrespositery2.UnitPrice)).getText();
		System.out.println("UniPriceFromWebTable:"+UniPriceFromWebTable);
		//String floatStringValueFromWebTable=UniPriceFromWebTable.substring(2);
		UniPriceFromWebTable=UniPriceFromWebTable.substring(2).trim();
		float unitPriceFloatVaue =  Float.parseFloat(UniPriceFromWebTable);
		float CalculatedUnitPriceFloatValue = unitPriceFloatVaue*5;
		System.out.println("CalculatedUnitPriceFloatValue:"+CalculatedUnitPriceFloatValue);
		
		String TotalPriceFromWebTable  = driver.findElement(By.xpath(objectrespositery2.TotalPrice)).getText();
		System.out.println("TotalPriceFromWebTable:"+TotalPriceFromWebTable);
		TotalPriceFromWebTable= TotalPriceFromWebTable.substring(2).trim();
		float TotalPriceFloatVaue =  Float.parseFloat(TotalPriceFromWebTable);
		System.out.println("TotalPriceFloatVaue:"+TotalPriceFloatVaue);
		Assert.assertEquals(CalculatedUnitPriceFloatValue, TotalPriceFloatVaue);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("inside beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("inside beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("inside afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
		//libraryfunction.LaunchBrowser();   /*  by using static method*/
		LaunchBrowser();
		
	}

	

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() throws Exception {
		System.out.println("inside beforeSuite");
	//	WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		//libraryfunction.ReadPropertiFile();  /*  by using static method*/
		ReadPropertiFile();
		
	}

	

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}

}
